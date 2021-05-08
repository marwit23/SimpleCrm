package com.marwit23.crm.item;

import com.marwit23.crm._constants.ItemType;
import com.marwit23.crm.company.Company;
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
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    private String itemRef;
    private String itemName;
    private Company supplier;
    private ItemType itemType;
    private BigDecimal rspPrice;
    private int supplierDiscount;
    private BigDecimal purchasePrice;
    private BigDecimal customerPrice;
    @Transient
    private BigDecimal unitProfit;

    @OneToMany(mappedBy = "item")
    private List<ProjectItem> projectItemList;




}
