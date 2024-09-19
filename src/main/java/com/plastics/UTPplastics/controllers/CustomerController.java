package com.plastics.UTPplastics.controllers;


import com.plastics.UTPplastics.entities.Customer;
import com.plastics.UTPplastics.services.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@CrossOrigin(origins = "*")
public class    CustomerController {
    @Autowired
    private CustomerServiceImp service;


    @GetMapping("/customers")//Traer todos los clientes
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/customer/{id}")  //Traer un cliente especifico
    public Customer getCustomer(@PathVariable Integer id) {
        return service.getCustomer(id);
    }

    @DeleteMapping("/customer/{id}")  //eliminar un cliente especificoss
    public void removeCustomer(@PathVariable Integer id){
        service.removeCustomer(id);
    }

    @PostMapping("/customer") //agregar clientes
    public void addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
    }

    @PutMapping("/customer/{id}") //agregar clientes
    public void updateCustomer(@PathVariable Integer id, @RequestBody Customer UpdateCustomer) {
        service.updateCustomer(id, UpdateCustomer);
    }

    @GetMapping("/customer/search")  //Busqueda
    public List<Customer> searchCustomer(@RequestParam(name="email",required = false) String email,
                                        @RequestParam(name="address",required = false) String address) {
        return  service.searchCustomer(email,address);
    }

}
