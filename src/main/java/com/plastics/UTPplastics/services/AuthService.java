package com.plastics.UTPplastics.services;

import com.plastics.UTPplastics.entities.Customer;

public interface AuthService {

    Customer login(String email, String password);
}
