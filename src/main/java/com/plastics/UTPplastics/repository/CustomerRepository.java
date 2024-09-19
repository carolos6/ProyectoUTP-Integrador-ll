package com.plastics.UTPplastics.repository;

import com.plastics.UTPplastics.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.email LIKE %:email% OR c.address LIKE %:address%")
    List<Customer> findByEmailOrAddress(@Param("email") String email,@Param("address") String address);

    @Query("SELECT c FROM Customer c WHERE c.email = :email AND  c.password = :password")
    List<Customer> findByEmailAndPassword(@Param("email") String email,
                                          @Param("password") String password);




}
