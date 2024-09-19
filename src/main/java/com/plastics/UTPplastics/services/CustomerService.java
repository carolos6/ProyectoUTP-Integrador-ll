package com.plastics.UTPplastics.services;
import com.google.common.hash.Hashing;

import com.plastics.UTPplastics.entities.Customer;
import com.plastics.UTPplastics.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomer( Integer id);
    void removeCustomer( Integer id);
    public void updateCustomer( Integer id, Customer UpdateCustomer);
    List<Customer> searchCustomer( String email, String address);
}
