package com.marwit23.crm.project;

import com.marwit23.crm.person.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    private ProjectRepo projectRepo;

    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public List<Project> findAll() {
        return projectRepo.findAll();
    }

    @Override
    public Project findById(Integer projectId) {
        Optional<Project> result = projectRepo.findById(projectId);
        Project theProject;
        if(result.isPresent()) theProject = result.get();
        else throw new RuntimeException("Unable to find this item.");
        return theProject;
    }

    @Override
    public void save(Project theProject) {
        projectRepo.save(theProject);

    }

    @Override
    public void deleteById(Integer projectId) {
        projectRepo.deleteById(projectId);

    }
}
