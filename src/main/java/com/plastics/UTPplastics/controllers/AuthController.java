package com.plastics.UTPplastics.controllers;

import com.plastics.UTPplastics.dto.RequestLogin;
import com.plastics.UTPplastics.entities.Customer;
import com.plastics.UTPplastics.services.AuthService;
import com.plastics.UTPplastics.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private AuthService  service;


    @PostMapping("/auth/login")
        public Customer login(@RequestBody  RequestLogin request) {
        String email   = request.getEmail();
        String password = request.getPassword();
        Customer customer = service.login(email, password);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Customer: " + customer);

            return customer;

    }
}
