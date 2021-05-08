package com.marwit23.crm.company;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @GetMapping("/{companyId}")
    public Company findById(@PathVariable Integer companyId) {
        return companyService.findById(companyId);
    }

    @PostMapping
    public Company saveCompany(@RequestBody Company theCompany) {
        companyService.save(theCompany);
        return theCompany;
    }

    @PutMapping("/{companyId}")
    public Company updateCompany(@RequestBody Company theCompany, @PathVariable Integer companyId) {
        theCompany.setCompanyId(companyId);
        companyService.save(theCompany);
        return theCompany;
    }

    @DeleteMapping("/{companyId}")
    public String deleteById(@PathVariable Integer companyId) {
        companyService.deleteById(companyId);
        return "Deleted company - " + companyId;
    }
}
