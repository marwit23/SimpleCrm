package com.marwit23.crm.projectitem;

import com.marwit23.crm.project.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProjectItemController {

    private ProjectItemService projectItemService;

    public ProjectItemController(ProjectItemService projectItemService) {
        this.projectItemService = projectItemService;
    }

    @GetMapping
    public List<ProjectItem> findAll() {
        return projectItemService.findAll();
    }

    @GetMapping("/{projectItemId}")
    public ProjectItem findById(@PathVariable Integer projectItemId) {
        return projectItemService.findById(projectItemId);
    }

    @PostMapping
    public void save(ProjectItem theProjectItem) {
        projectItemService.save(theProjectItem);
    }

    @PutMapping("/{projectItemId}")
    public ProjectItem updateProject(@RequestBody ProjectItem theProjectItem, @PathVariable Integer projectItemId) {
        theProjectItem.setProjectItemId(projectItemId);
        projectItemService.save(theProjectItem);
        return theProjectItem;
    }

    @DeleteMapping("/{projectItemId}")
    public String deleteById(@PathVariable Integer projectItemId) {
        projectItemService.deleteById(projectItemId);
        return "Deleted item - " + projectItemId;
    }
}
