package com.marwit23.crm.actions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marwit23.crm._constants.ActionType;
import com.marwit23.crm.project.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Action {

    //TODO: Task instead of Action???
    //TODO: Task result (e.g. no pickup), date?
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actionId;

    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    @CreatedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate actionDate;

    @ManyToOne
    @JoinColumn(name = "actions")
    @JsonIgnoreProperties({"actions"})
    private Project project;

}
