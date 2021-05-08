package com.marwit23.crm.person;

import com.marwit23.crm.company.Company;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person findById(Integer personId);
    void save(Person thePerson);
    void deleteById(Integer personId);
}
