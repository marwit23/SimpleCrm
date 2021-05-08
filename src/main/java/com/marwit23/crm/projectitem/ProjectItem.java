package com.marwit23.crm.projectitem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marwit23.crm.item.Item;
import com.marwit23.crm.project.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProjectItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectItemId;

    @ManyToOne
    @JoinColumn(name = "projectItems")
    @JsonIgnoreProperties("projectItems")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "projectItemList")
    @JsonIgnoreProperties("projectItemList")
    private Item item;

    private BigDecimal purchasePrice;
    private int pcs;
    @Transient
    private BigDecimal purchaseValue;
    @Transient
    private BigDecimal sellingValue;
}
