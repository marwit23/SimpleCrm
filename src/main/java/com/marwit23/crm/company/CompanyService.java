package com.marwit23.crm.company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    Company findById(Integer companyId);
    void save(Company theCompany);
    void deleteById(Integer companyId);
}