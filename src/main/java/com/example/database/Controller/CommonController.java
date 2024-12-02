package com.example.database.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.Relationship.exchangeResponseDto;
import com.example.database.Service.customerService;

@RestController
public class CommonController {
    @Autowired
    customerService customerService;

    @PreAuthorize("hasAnyRole('MANAGER','CUSTOMER','EMPLOYEE')")
    @GetMapping("/giftExchange/view")
    public List<exchangeResponseDto> getExchange(Principal principal) {
        return customerService.getExchange(principal.getName());
    }
}
