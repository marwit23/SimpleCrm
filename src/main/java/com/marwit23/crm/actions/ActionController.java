package com.marwit23.crm.actions;

import com.marwit23.crm.project.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actions")
public class ActionController {

    private ActionService actionService;

    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping
    public List<Action> findAll() {
        return actionService.findAll();
    }

    @GetMapping("/{actionId}")
    public Action findById(Integer actionId) {
        return actionService.findById(actionId);
    }

    @PostMapping
    public Action saveAction(@RequestBody Action theAction) {
        actionService.save(theAction);
        return theAction;
    }

    @PutMapping("/{actionId}")
    public Action updateAction(@RequestBody Action theAction, @PathVariable Integer actionId) {
        theAction.setActionId(actionId);
        actionService.save(theAction);
        return theAction;
    }

    @DeleteMapping("/{actionId}")
    public String deleteById(@PathVariable Integer actionId) {
        actionService.deleteById(actionId);
        return "Deleted item - " + actionId;
    }
}
