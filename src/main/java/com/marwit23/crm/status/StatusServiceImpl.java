package com.marwit23.crm.status;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    private StatusRepo statusRepo;

    public StatusServiceImpl(StatusRepo statusRepo) {
        this.statusRepo = statusRepo;
    }

    @Override
    public List<Status> findAll() {
        return statusRepo.findAll();
    }

    @Override
    public Status findById(Integer statusId) {
        Optional<Status> result = statusRepo.findById(statusId);
        Status theStatus;
        if(result.isPresent()) theStatus = result.get();
        else throw new RuntimeException("Unable to find this item.");
        return theStatus;
    }

    @Override
    public void save(Status theStatus) {
        statusRepo.save(theStatus);

    }

    @Override
    public void deleteById(Integer statusId) {
        statusRepo.deleteById(statusId);

    }
}
