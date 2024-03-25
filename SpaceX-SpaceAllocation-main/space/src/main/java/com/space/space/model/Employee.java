package com.space.space.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private int employeeId;
    private String employeeName;
    private int reportsTo;
    private String designation;
    private String OECode;
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_OE_code")
    private Team team;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_OE_code")
    private Department department;

    @OneToOne(mappedBy = "employee")
    @JsonManagedReference
    private Seat seat;
}
