package com.marwit23.crm.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marwit23.crm.company.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    private String firstName;
    private String surname;

    @ManyToOne
    @JoinColumn(name = "companyId")
    @JsonIgnoreProperties("persons")
    private Company company;
    private String jobTitle;
    private String telephoneNumber;
    private String telephoneNumber2;
    private String emailAddress;
    private String notes;


}
