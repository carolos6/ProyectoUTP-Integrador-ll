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
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    private static final String SECRET_KEY="CDSVFS";


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

        String hashPassword = Hashing.sha256().
                hashString(customer.getPassword()+SECRET_KEY, StandardCharsets.UTF_8).
                toString();
        customer.setPassword(hashPassword);
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