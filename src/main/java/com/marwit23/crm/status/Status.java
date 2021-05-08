package com.marwit23.crm.status;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marwit23.crm._constants.StatusType;
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
public class Status {

    //TODO: Task instead of Action???
    //TODO: Task result (e.g. no pickup), date?
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;

    @Enumerated(EnumType.STRING)
    private StatusType statusType;

    @CreatedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate statusDate;

    @ManyToOne
    @JoinColumn(name = "actions")
    @JsonIgnoreProperties({"actions"})
    private Project project;

}
