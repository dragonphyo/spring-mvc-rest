package com.example.mvcrestmodelmapper.service;

import com.example.mvcrestmodelmapper.domain.Person;
import com.example.mvcrestmodelmapper.domain.PersonDTO;
import com.example.mvcrestmodelmapper.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    public PersonServiceImpl(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Person create(PersonDTO person) {
        return this.personRepository.save(convertToEntity(person));
    }

    @Override
    public List<PersonDTO> findAll() {
        List<PersonDTO> personDTOList = new ArrayList<>();
        for(Person person : personRepository.findAll()){
            personDTOList.add(convertToDTO(person));
        }
        return personDTOList;
    }

    @Override
    public PersonDTO findById(int id) {
        return convertToDTO(personRepository.getOne(id));
    }

    @Override
    public void delete(int id) {
        this.personRepository.deleteById(id);
    }

    @Override
    @Transactional
    public PersonDTO update(int id,PersonDTO person) {
        PersonDTO oldPerson = findById(id);
        oldPerson.setName(person.getName());
        oldPerson.setAge(person.getAge());
        oldPerson.setPhoneNumber(person.getPhoneNumber());
        oldPerson.setStreetName(person.getStreetName());
        oldPerson.setZipCode(person.getZipCode());
        return oldPerson;
    }

    @Override
    @Transactional
    public PersonDTO updateName(int id, String name) {
        PersonDTO oldPerson = findById(id);
        oldPerson.setName(name);
        return oldPerson;
    }

    private Person convertToEntity(PersonDTO personDTO){
        return modelMapper.map(personDTO,Person.class);
    }
    private PersonDTO convertToDTO(Person person){
        return modelMapper.map(person,PersonDTO.class);
    }
}
