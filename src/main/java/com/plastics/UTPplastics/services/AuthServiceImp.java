package com.plastics.UTPplastics.services;

import com.google.common.hash.Hashing;
import com.plastics.UTPplastics.entities.Customer;
import com.plastics.UTPplastics.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;



@Service
public class AuthServiceImp implements AuthService {

    private static final String SECRET_KEY="CDSVFS";
    @Autowired
    private CustomerRepository customerRepository;

    //HASHIN
    @Override
    public Customer login(String email, String password) {

        String hashPassword = Hashing.sha256().
                hashString(password+SECRET_KEY , StandardCharsets.UTF_8).
                toString();
        List<Customer> result =customerRepository.findByEmailAndPassword(email, hashPassword);
        System.out.println();
        if ( result.isEmpty()){
            //no encontro nada
            System.out.println("No se encontró ningún cliente con email: " + email + " y contraseña hasheada: " + hashPassword);
            return null;

        }else{
            System.out.println(result.get(0).getId());
            return result.get(0);
        }
    }
}
