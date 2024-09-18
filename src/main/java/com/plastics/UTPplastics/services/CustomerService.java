package com.plastics.UTPplastics.services;

import com.plastics.UTPplastics.entities.Customer;
import com.plastics.UTPplastics.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        Iterable<Customer> customers= customerRepository.findAll();
        for ( Customer customer : customers ) {
            list.add(customer);
        }
        return list;
    }

    public Customer getCustomer( Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            return customer.get();
        }
        return null;
    }
    public void removeCustomer( Integer id){
        customerRepository.deleteById(id);
    }
    public void addCustomer( Customer customer) {

        customerRepository.save(customer);

    }
    public void updateCustomer( Integer id, Customer UpdateCustomer) {
        UpdateCustomer.setId(id);
        customerRepository.save(UpdateCustomer);
    }

    public List<Customer> searchCustomer( String email, String address) {
        return customerRepository.findByEmailOrAddress(email,address);
    }

}