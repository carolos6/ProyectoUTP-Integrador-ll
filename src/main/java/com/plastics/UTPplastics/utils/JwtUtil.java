package com.plastics.UTPplastics.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.plastics.UTPplastics.entities.Customer;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY="CDSVFS";

    public static String generateToken(Customer customer){
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        Algorithm algorithm= Algorithm.HMAC256(SECRET_KEY);
        String token= JWT.create()
                .withIssuer("UTPplastics")
                .withClaim("customerId", customer.getId())
                .withIssuedAt(new Date())
                .withExpiresAt(getExpiresDate())
                .sign(algorithm);
        return token;
    }
    private static Date getExpiresDate(){
        return new  Date(System.currentTimeMillis()
                +(1000L*60*60*24*14));    //14 dias
    }


    //public Customer getCustomerByToken(JwtToken token){

}//

