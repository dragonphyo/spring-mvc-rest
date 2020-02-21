package com.example.mvcrestmodelmapper.controller;

import com.example.mvcrestmodelmapper.domain.Person;
import com.example.mvcrestmodelmapper.domain.PersonDTO;
import com.example.mvcrestmodelmapper.service.PersonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/creation")
    public String create(){
        Arrays.asList(new PersonDTO(null,"Thaw Thaw","Dream Land","12345","12345",23),
                new PersonDTO(null,"Thaw Thaw","Dream Land","12345","12345",23),
        new PersonDTO(null,"Thaw Thaw","Dream Land","12345","12345",25)
                ).forEach(personService::create);
        return "successfully created.";
    }

    @GetMapping("/person/all")
    public List<PersonDTO> findAll(){
      return   personService.findAll();
    }

    @GetMapping("/person/all/{id}")
    public PersonDTO findById(@PathVariable int id){
        return personService.findById(id);
    }
    @DeleteMapping("/person/all/{id}")
    public void deleteById(@PathVariable int id){
        personService.delete(id);
    }

    @PutMapping(value = "/person/all/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO updateById(@PathVariable int id,@RequestBody PersonDTO person){
        return this.personService.update(id,person);
    }

    @PatchMapping(value = "/person/all/{id}",consumes = MediaType.TEXT_PLAIN_VALUE)
    public PersonDTO updateName(@PathVariable int id,@RequestBody String name){
        return this.personService.updateName(id,name);

    }
}
