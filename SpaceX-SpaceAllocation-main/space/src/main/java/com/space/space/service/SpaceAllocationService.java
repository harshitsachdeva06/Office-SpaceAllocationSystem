package com.space.space.service;

import com.space.space.model.DepartmentSeats;

public interface SpaceAllocationService {
    boolean allocateSpace(Space space);
    DepartmentSeats getAllSeats(int empId);
}
