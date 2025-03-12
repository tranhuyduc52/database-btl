package com.example.database.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.dto.request.CustomerRequest;
import com.example.database.dto.respone.GiftResponse;
import com.example.database.dto.respone.ProductResponse;
import com.example.database.dto.respone.ReviewResponse;
import com.example.database.security.JwtUtils;
import com.example.database.security.LoginRequest;
import com.example.database.security.LoginResponse;
import com.example.database.service.impl.CustomerService;
import com.example.database.service.impl.GiftService;
import com.example.database.service.impl.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired 
    private CustomerService customerService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    DataSource dataSource;
    @Autowired
    private ProductService productService;
    @Autowired
    private GiftService giftService;
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (AuthenticationException exception) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad credentials");
            map.put("status", false);
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        LoginResponse response = new LoginResponse(userDetails.getUsername(), roles, jwtToken);

        return ResponseEntity.ok(response);
    }
    @PostMapping("customer/createAccount")
    public String createCustomer(@RequestBody CustomerRequest dto) 
    {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        if(manager.userExists(dto.phoneNumber())){return "Username already exists";}

        UserDetails user = User.withUsername(dto.phoneNumber())
        .password(passwordEncoder.encode(dto.password()))
        .roles("CUSTOMER")
        .build();
        manager.createUser(user);
        customerService.createCustomer(dto);
        return "Your account is created successfully!";
    }
    //api này không cần code vào react, t dùng để tạo tài khoản admin
    @PostMapping("admin")
    public String createManager(@RequestBody LoginRequest dto) 
    {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        if(manager.userExists(dto.getUsername())){return "Username already exists";}

        UserDetails user = User.withUsername(dto.getUsername())
        .password(passwordEncoder.encode(dto.getPassword()))
        .roles("MANAGER")
        .build();
        manager.createUser(user);
        return "Your account is created successfully!";
    }

    @GetMapping("/menu")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/gift/view")
    public List<GiftResponse> getAllGifts() {
        return giftService.findAllGift();
    }
    @GetMapping("/product/review")
    public List<ReviewResponse> getProductReview(@RequestParam int productId) {
        return productService.getReview(productId);
        //return new String();
    }
    
    
}
// @PreAuthorize("hasRole('CUSTOMER')")  //use to specify role access should go with enableMethodSecurity
// @GetMapping("/user")
// public String userPage(
//     Principal principal,
//     Authentication authentication
// ) 
// {
//     return principal.getName(); //get username
//     // return authentication.getAuthorities().stream()
//     // .map(GrantedAuthority::getAuthority)
//     // .collect(Collectors.toList());                    //get role, role sẽ ở dạng ROLE_TÊN ROLE
// }