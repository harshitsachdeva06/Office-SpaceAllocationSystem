package com.space.space.repository;

import com.space.space.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,String> {
    Department findByDepartmentOECode(String departmentOECode);
}
