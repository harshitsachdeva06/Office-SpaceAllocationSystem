package com.space.space.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SectionAllocation {
    @Id
    @GeneratedValue
    private int allocationId;
    private String teamOECode;
    private Date startDate;
    private Date endDate;
    private String seatIdStart;
    private String seatIdEnd;
}
