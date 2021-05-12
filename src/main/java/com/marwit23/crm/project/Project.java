package com.marwit23.crm.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marwit23.crm.person.Person;
import com.marwit23.crm.status.Status;
import com.marwit23.crm.company.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {

    //TODO: project_type (machine, parts, other)
    //TODO: project_type (mailing)
    //TODO: transient lastStatus
    //TODO: transient person
    //TODO: project notes, company notes, person notes
    //TODO: project date
    //TODO: project ref, nr kontraktu, nr zamówienia u nas i u producenta
    //TODO: usunąć listę statusów i dać jeden statusDesc i statusType?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String projectDescription;

    @ManyToOne
    @JsonIgnoreProperties({"persons"})
    private Company customer;

    @ManyToOne
    @JsonIgnoreProperties({"persons"})
    private Company supplier;

    @CreatedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate projectDate;

    @OneToMany(mappedBy = "project")
    private List<Status> statusList;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            joinColumns = @JoinColumn(name = "projectId"),
            inverseJoinColumns = @JoinColumn(name = "personId")
    )
    private List<Person> persons;

//    @Transient
//    private Status lastStatus;
//
//    public Status getLastStatus() {
//        for(Status status in statusList) {
//
//        }
//        return lastStatus;
//    }

    //    @PostLoad
//    protected void onLoad() {
//        updateLastStatus();
//    }
//
//    private void updateLastStatus() {
//
//    }


}
