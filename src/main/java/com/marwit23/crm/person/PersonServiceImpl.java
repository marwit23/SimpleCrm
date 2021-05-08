package com.marwit23.crm.person;

import com.marwit23.crm.company.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    private PersonRepo personRepo;

    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public List<Person> findAll() {
        return personRepo.findAll();
    }

    @Override
    public Person findById(Integer personId) {
        Optional<Person> result = personRepo.findById(personId);
        Person thePerson;
        if(result.isPresent()) thePerson = result.get();
        else throw new RuntimeException("Unable to find this item.");
        return thePerson;
    }

    @Override
    public void save(Person thePerson) {
        personRepo.save(thePerson);
    }

    @Override
    public void deleteById(Integer personId) {
        personRepo.deleteById(personId);
    }
}
