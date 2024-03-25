package com.space.space.service;

import com.space.space.model.SeatAllocation;
import org.springframework.stereotype.Service;


public interface SeatAllocationService {

    boolean allocateSeat(SeatAllocation seatAllocation);
}
