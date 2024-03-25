package com.space.space.repository;

import com.space.space.model.SpaceAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpaceAllocationRepo extends JpaRepository<SpaceAllocation,Integer> {

    SpaceAllocation findByDepartmentOECode(String departmentOECode);

    @Query("select seat_id from seat where department_oe_code is null and floor= ?floor order by seat_id  limit 1 ")
    String getStartSeat(int floor);

}
