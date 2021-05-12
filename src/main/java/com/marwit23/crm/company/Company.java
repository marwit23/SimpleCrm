package com.marwit23.crm.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marwit23.crm._constants.CompanyIndustry;
import com.marwit23.crm._constants.CompanyType;
import com.marwit23.crm.person.Person;
import com.marwit23.crm.project.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {

    //TODO: company / project source (old, incoming, emails, namecards, internet)
    //TODO: company prospect (not_interested, neutral, interested, opened_project)
    // Może tutaj dodać telefony, albo do osoby
    // Boolean czy touched
    // Company notes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;
    private String companyName;

    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    @Enumerated(EnumType.STRING)
    private CompanyIndustry companyIndustry;

    @OneToMany(mappedBy = "company")
    private List<Person> persons;

}
