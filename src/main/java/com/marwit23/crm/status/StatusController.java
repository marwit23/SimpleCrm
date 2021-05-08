package com.marwit23.crm.status;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actions")
public class StatusController {

    private StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public List<Status> findAll() {
        return statusService.findAll();
    }

    @GetMapping("/{statusId}")
    public Status findById(Integer statusId) {
        return statusService.findById(statusId);
    }

    @PostMapping
    public Status saveAction(@RequestBody Status theStatus) {
        statusService.save(theStatus);
        return theStatus;
    }

    @PutMapping("/{statusId}")
    public Status updateAction(@RequestBody Status theStatus, @PathVariable Integer statusId) {
        theStatus.setStatusId(statusId);
        statusService.save(theStatus);
        return theStatus;
    }

    @DeleteMapping("/{statusId}")
    public String deleteById(@PathVariable Integer statusId) {
        statusService.deleteById(statusId);
        return "Deleted item - " + statusId;
    }
}
