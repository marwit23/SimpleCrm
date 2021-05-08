package com.marwit23.crm.person;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{personId}")
    public Person findById(@PathVariable Integer personId) {
        return personService.findById(personId);
    }

    @PostMapping
    public void save(@RequestBody Person thePerson) {
        personService.save(thePerson);
    }

    @PutMapping("/{personId}")
    public Person updatePerson(@RequestBody Person thePerson, @PathVariable Integer personId) {
        thePerson.setPersonId(personId);
        personService.save(thePerson);
        return thePerson;
    }

    @DeleteMapping("/{personId}")
    public String deleteById(@PathVariable Integer personId) {
        personService.deleteById(personId);
        return "Deleted item - " + personId;
    }
}
