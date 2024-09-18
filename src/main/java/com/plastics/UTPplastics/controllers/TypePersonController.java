package com.plastics.UTPplastics.controllers;


import com.plastics.UTPplastics.entities.Customer;
import com.plastics.UTPplastics.entities.TypePerson;
import com.plastics.UTPplastics.services.TypePersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class TypePersonController {
    @Autowired
    private TypePersonService service;

    @GetMapping("/typePerson")//Traer todas las categorias de usuario
    public List<TypePerson> getAllTypePerson() {
        return service.getAllTypePersons();
    }
    @GetMapping("/typePerson/{id}")  //Traer un Tipo persona especifico
    public TypePerson getTypePerson(@PathVariable Integer id) {
        return service.getTypePerson(id);
    }
    @DeleteMapping("/typePerson/{id}")  //eliminar un tipo persona espec    ificoss
    public void removeTypePerson (@PathVariable Integer id){
        service.removeTypePerson(id);
    }
    @PostMapping("/typePerson") //agregar un tipo persona
    public void addTypePerson(@RequestBody TypePerson typePerson) {
        service.addTypePerson(typePerson);
    }
    @PutMapping("/typePerson/{id}") //agregar clientes
    public void updateTypePerson(@PathVariable Integer id, @RequestBody TypePerson typePerson) {
        service.updateTypePerson(id, typePerson);
    }

}
