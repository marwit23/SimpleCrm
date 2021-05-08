package com.marwit23.crm.projectitem;

import com.marwit23.crm.project.Project;

import java.util.List;

public interface ProjectItemService {
    List<ProjectItem> findAll();
    ProjectItem findById(Integer projectItemId);
    void save(ProjectItem theProjectItem);
    void deleteById(Integer projectItemId);

}
