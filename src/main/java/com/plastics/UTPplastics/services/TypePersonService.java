package com.plastics.UTPplastics.services;


import com.plastics.UTPplastics.entities.Customer;
import com.plastics.UTPplastics.entities.TypePerson;
import com.plastics.UTPplastics.repository.TypePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TypePersonService {
    @Autowired
    private TypePersonRepository repo;


    public List<TypePerson> getAllTypePersons() {
        List<TypePerson> list = new ArrayList<>();
        Iterable<TypePerson> customers= repo.findAll();
        for ( TypePerson typeperson : customers ) {
            list.add(typeperson);
        }
        return list;
    }
    public TypePerson getTypePerson(Integer id) {
        Optional<TypePerson> typeperson = repo.findById(id);
        if(typeperson.isPresent()) {
            return typeperson.get();
        }
        return null;
    }
    public void removeTypePerson( Integer id){
        repo.deleteById(id);
    }
    public void addTypePerson( TypePerson typePerson) {
        repo.save(typePerson);
    }
    public void updateTypePerson( Integer id, TypePerson UpdateTypePerson) {
        UpdateTypePerson.setId(id);
        repo.save(UpdateTypePerson);
    }


}
