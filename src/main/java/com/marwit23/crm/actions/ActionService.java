package com.marwit23.crm.actions;

import com.marwit23.crm.project.Project;

import java.util.List;

public interface ActionService {
    List<Action> findAll();
    Action findById(Integer actionId);
    void save(Action theAction);
    void deleteById(Integer actionId);
}
