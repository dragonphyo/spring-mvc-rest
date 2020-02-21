package com.example.mvcrestmodelmapper.service;

import com.example.mvcrestmodelmapper.domain.Person;
import com.example.mvcrestmodelmapper.domain.PersonDTO;

import java.util.List;

public interface PersonService {
    Person create(PersonDTO person);
    List<PersonDTO> findAll();
    PersonDTO findById(int id);
    public void delete(int id);
    public PersonDTO update(int id,PersonDTO person);
    public PersonDTO updateName(int id, String name);

}
