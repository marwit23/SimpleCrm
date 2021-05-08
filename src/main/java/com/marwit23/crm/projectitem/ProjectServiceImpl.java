package com.marwit23.crm.projectitem;

import com.marwit23.crm.project.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectItemService{

    private ProjectItemRepo projectItemRepo;

    public ProjectServiceImpl(ProjectItemRepo projectItemRepo) {
        this.projectItemRepo = projectItemRepo;
    }

    @Override
    public List<ProjectItem> findAll() {
        return projectItemRepo.findAll();
    }

    @Override
    public ProjectItem findById(Integer projectItemId) {
        Optional<ProjectItem> result = projectItemRepo.findById(projectItemId);
        ProjectItem theProjectItem;
        if(result.isPresent()) theProjectItem = result.get();
        else throw new RuntimeException("Unable to find this item.");
        return theProjectItem;
    }

    @Override
    public void save(ProjectItem theProjectItem) {
        projectItemRepo.save(theProjectItem);

    }

    @Override
    public void deleteById(Integer projectItemId) {
        projectItemRepo.deleteById(projectItemId);

    }
}
