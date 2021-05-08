package com.marwit23.crm.project;

import com.marwit23.crm.person.Person;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @GetMapping("/{projectId}")
    public Project findById(@PathVariable Integer projectId) {
        return projectService.findById(projectId);
    }

    @PostMapping
    public Project saveProject(@RequestBody Project theProject) {
        projectService.save(theProject);
        return theProject;
    }

    @PutMapping("/{projectId}")
    public Project updateProject(@RequestBody Project theProject, @PathVariable Integer projectId) {
        theProject.setProjectId(projectId);
        projectService.save(theProject);
        return theProject;
    }

    @DeleteMapping("/{projectId}")
    public String deleteById(Integer projectId) {
        projectService.deleteById(projectId);
        return "Deleted item - " + projectId;
    }
}
