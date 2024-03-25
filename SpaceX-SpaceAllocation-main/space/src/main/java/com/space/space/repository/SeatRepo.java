package com.space.space.repository;

import com.space.space.model.Employee;
import com.space.space.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat, String> {

    Seat findByEmployee(Employee employee);
}
