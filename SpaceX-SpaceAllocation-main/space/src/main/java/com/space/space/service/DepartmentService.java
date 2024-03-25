package com.space.space.service;

import com.space.space.exception.DepartmentNotFoundException;
import com.space.space.model.Department;
import com.space.space.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    public Department addDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public Department updateDepartment(String departmentOECode, Department department) {
        Department old_department = departmentRepo.findById(departmentOECode).get();
        old_department.setName(department.getName());
        old_department.setVPEmpId(department.getVPEmpId());
        return departmentRepo.save(old_department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    public Department getDepartmentById(String id) {
        return departmentRepo.findById(id).orElseThrow(() -> new
                DepartmentNotFoundException("Department with id : " + id + " not found"));
    }

    public boolean deleteDepartmentById(String id) {
        departmentRepo.deleteById(id);
        return !departmentRepo.existsById(id);
    }
}
