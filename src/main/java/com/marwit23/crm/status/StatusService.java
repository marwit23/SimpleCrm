package com.marwit23.crm.status;

import java.util.List;

public interface StatusService {
    List<Status> findAll();
    Status findById(Integer statusId);
    void save(Status theStatus);
    void deleteById(Integer statusId);
}
