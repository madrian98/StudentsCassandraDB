package com.cassandra.enterprise.controller;

import com.cassandra.enterprise.ResourceNotFoundException;
import com.cassandra.enterprise.model.Person;

import com.cassandra.enterprise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class PersonController
{
    @Autowired
    PersonRepository personRepository;

    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person){
        personRepository.save(person);
        return person;
    }

    @GetMapping("/persons/list/{id}")
    public ResponseEntity<Person> findById(@PathVariable("id") Integer personID){
        Person person=personRepository.findById(personID).orElseThrow(
                () -> new ResourceNotFoundException("Not found :" + personID));
        return ResponseEntity.ok().body(person);
    }



    @GetMapping("/persons/show")
    public List<Person> getPersons(){

        return personRepository.findAll();
    }

    @PutMapping("person/edit/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Integer personID,
                                                 @RequestBody Person personDetails) {
        Person person = personRepository.findById(personID)
                .orElseThrow(() -> new ResourceNotFoundException("Not found person with that ID  : " + personID));
        person.setFirst_name(personDetails.getFirst_name());
        person.setLast_name(personDetails.getLast_name());
        person.setEmail(personDetails.getEmail());
        person.setGender(personDetails.getGender());
        person.setCity(personDetails.getCity());
        person.setCountry(personDetails.getCountry());
        person.setJob_title(personDetails.getJob_title());
        person.setCompany_name(personDetails.getCompany_name());
        person.setCar_make(personDetails.getCar_make());
        person.setModel_year(personDetails.getModel_year());
        final Person updatedPerson = personRepository.save(person);
        return ResponseEntity.ok(updatedPerson);

    }

    @DeleteMapping("persons/delete/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable(value = "id") Integer personID) {
        Person person = personRepository.findById(personID).orElseThrow(
                () -> new ResourceNotFoundException("Not found:: " + personID));
        personRepository.delete(person);
        return ResponseEntity.ok().build();
    }

}
