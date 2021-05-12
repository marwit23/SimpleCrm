package com.marwit23.crm.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marwit23.crm.company.Company;
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
public class Person {

    // TODO: person_status (RIGHT, WRONG, NOT_WORK)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    private String firstName;
    private String surname;

    @ManyToOne
    @JoinColumn(name = "companyId")
    @JsonIgnoreProperties("persons")
    private Company company;

    @ManyToMany(mappedBy = "persons", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnoreProperties("persons")
    private List<Project> projects;

    private String jobTitle;
    private String telephoneNumber;
    private String telephoneNumber2;
    private String emailAddress;
    private String notes;


}
