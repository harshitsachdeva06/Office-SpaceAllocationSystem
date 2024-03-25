package com.space.space.controller;

import com.space.space.model.SeatAllocation;
import com.space.space.service.SeatAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatAllocationController {

    @Autowired
    private SeatAllocationService seatAllocationService;

    @PostMapping("/spaceX/allocateSeat")
    public boolean allocateSection(@RequestBody SeatAllocation seatAllocation) {
        return seatAllocationService.allocateSeat(seatAllocation);
    }
}
