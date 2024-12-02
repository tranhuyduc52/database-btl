package com.example.database.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import javax.management.relation.Role;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
                                        Authentication authentication) 
                                        throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        var listRole = userDetails.getAuthorities();
        for(var i: listRole){
            
        }
        //response.sendRedirect("/public/home");
    }
}
