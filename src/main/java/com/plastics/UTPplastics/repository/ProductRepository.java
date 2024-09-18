package com.plastics.UTPplastics.repository;

import com.plastics.UTPplastics.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
