package com.plastics.UTPplastics.services;

import com.plastics.UTPplastics.entities.ProductType;
import com.plastics.UTPplastics.entities.TypePerson;
import com.plastics.UTPplastics.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository repo;

    public List<ProductType> getAllProductType() {
        List<ProductType> list = new ArrayList<>();
        Iterable<ProductType>  productType= repo.findAll();
        for ( ProductType producttype : productType ) {
            list.add(producttype);
        }
        return list;
    }
    public ProductType getProductType(Integer id) {
        Optional<ProductType> productType = repo.findById(id);
        if(productType.isPresent()) {
            return productType.get();
        }
        return null;
    }
    public void removeProductType(Integer id){
        repo.deleteById(id);
    }

    public void addProductType( ProductType productType) {
        repo.save(productType);
    }
    public void updateProductType( Integer id, ProductType UpdateProductType) {
        UpdateProductType.setId(id);
        repo.save(UpdateProductType);
    }


}
