package com.marwit23.crm.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marwit23.crm.status.Status;
import com.marwit23.crm.company.Company;
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
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "projects")
    @JsonIgnoreProperties({"projects", "persons"})
    private Company customer;

    @OneToMany(mappedBy = "project")
    private List<Status> statusList;

}
