package com.plastics.UTPplastics.services;

import com.plastics.UTPplastics.entities.Product;
import com.plastics.UTPplastics.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        Iterable<Product>  products= repo.findAll();
        for ( Product product : products ) {
            list.add(product);
        }
        return list;
    }
    public Product getProduct(Integer id) {
        Optional<Product> product = repo.findById(id);
        if(product.isPresent()) {
            return product.get();
        }
        return null;
    }
    public void removeProduct(Integer id){
        repo.deleteById(id);
    }

    public void addProduct( Product product) {
        repo.save(product);
    }
    public void updateProduct(Integer id, Product UpdateProduct) {
        UpdateProduct.setId(id);
        repo.save(UpdateProduct);
    }


}
