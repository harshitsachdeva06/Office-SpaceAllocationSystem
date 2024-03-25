package com.space.space.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Space {
    private int empId;
    private int numberOfSeats;
    private Date sDate;
    private Date eDate;
    private int floor;
}
