package com.marwit23.crm.project;

import com.marwit23.crm.person.Person;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project findById(Integer projectId);
    void save(Project theProject);
    void deleteById(Integer projectId);


}
