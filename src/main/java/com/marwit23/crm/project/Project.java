package com.marwit23.crm.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marwit23.crm.actions.Action;
import com.marwit23.crm.company.Company;
import com.marwit23.crm.item.Item;
import com.marwit23.crm.person.Person;
import com.marwit23.crm.projectitem.ProjectItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private List<ProjectItem> projectItems;

    @OneToMany(mappedBy = "project")
    private List<Action> actionList;

    @Transient
    private BigDecimal purchaseSum;
    @Transient
    private BigDecimal sellingSum;
    @Transient
    private BigDecimal profit;
    private int discount;


}
