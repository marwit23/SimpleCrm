package com.marwit23.crm.actions;

import com.marwit23.crm.project.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionServiceImpl implements ActionService{

    private ActionRepo actionRepo;

    public ActionServiceImpl(ActionRepo actionRepo) {
        this.actionRepo = actionRepo;
    }

    @Override
    public List<Action> findAll() {
        return actionRepo.findAll();
    }

    @Override
    public Action findById(Integer actionId) {
        Optional<Action> result = actionRepo.findById(actionId);
        Action theAction;
        if(result.isPresent()) theAction = result.get();
        else throw new RuntimeException("Unable to find this item.");
        return theAction;
    }

    @Override
    public void save(Action theAction) {
        actionRepo.save(theAction);

    }

    @Override
    public void deleteById(Integer actionId) {
        actionRepo.deleteById(actionId);

    }
}
