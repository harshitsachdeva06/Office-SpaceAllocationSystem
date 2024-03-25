package com.space.space.repository;

import com.space.space.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    Employee findByEmployeeId(int id);
}
