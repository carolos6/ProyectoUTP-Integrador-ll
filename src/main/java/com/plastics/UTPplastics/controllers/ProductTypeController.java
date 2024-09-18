package com.plastics.UTPplastics.controllers;

import com.plastics.UTPplastics.entities.ProductType;
import com.plastics.UTPplastics.entities.TypePerson;
import com.plastics.UTPplastics.services.ProductTypeService;
import com.plastics.UTPplastics.services.TypePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductTypeController {
    @Autowired
    private ProductTypeService service;

    @GetMapping("/productType")//Traer todas las categorias de usuario
    public List<ProductType> getAllProductTypes() {
        return service.getAllProductType();
    }
    @GetMapping("/productType/{id}")  //Traer un Tipo de producto en especifico
    public ProductType getProductType(@PathVariable Integer id) {
        return service.getProductType(id);
    }
    @DeleteMapping("/productType/{id}")  //eliminar un tipo persona especificoss
    public void removeProductType (@PathVariable Integer id){
        service.removeProductType(id);
    }
    @PostMapping("/productType") //agregar un tipo persona
    public void addProductType(@RequestBody ProductType productType) {
        service.addProductType(productType);
    }
    @PutMapping("/productType/{id}") //agregar clientes
    public void updateProductType(@PathVariable Integer id, @RequestBody ProductType productType) {
        service.updateProductType(id, productType);
    }
}
