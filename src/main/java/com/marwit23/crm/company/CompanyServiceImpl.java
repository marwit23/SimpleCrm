package com.marwit23.crm.company;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepo companyRepo;

    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public List<Company> findAll() {
        return companyRepo.findAll();
    }

    @Override
    public Company findById(Integer companyId) {
        Optional<Company> result = companyRepo.findById(companyId);
        Company theCompany;
        if(result.isPresent()) theCompany = result.get();
        else throw new RuntimeException("Unable to find this item.");
        return theCompany;
    }

    @Override
    public void save(Company theCompany) {
        companyRepo.save(theCompany);

    }

    @Override
    public void deleteById(Integer companyId) {
        companyRepo.deleteById(companyId);
    }
}
