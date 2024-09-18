package com.plastics.UTPplastics.controllers;

import com.plastics.UTPplastics.entities.Customer;
import com.plastics.UTPplastics.entities.Product;
import com.plastics.UTPplastics.services.CustomerService;
import com.plastics.UTPplastics.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;


    @GetMapping("/product")//Traer todos los productos
    public List<Product> getAllCustomers() {
        return service.getAllProducts();
    }

    @GetMapping("/product/{id}")  //Traer un cliente especifico
    public Product getProduct(@PathVariable Integer id) {
        return service.getProduct(id);
    }

    @DeleteMapping("/product/{id}")  //eliminar un cliente especificoss
    public void removeProduct(@PathVariable Integer id){
        service.removeProduct(id);
    }

    @PostMapping("/product") //agregar clientes
    public void addProduct(@RequestBody Product product) {
        service.addProduct(product);
    }

    @PutMapping("/product/{id}") //agregar clientes
    public void updateProduct(@PathVariable Integer id, @RequestBody Product UpdateProduct) {
        service.updateProduct(id, UpdateProduct);
    }

}
