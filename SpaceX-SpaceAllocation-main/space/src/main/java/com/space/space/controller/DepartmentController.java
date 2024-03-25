package com.space.space.controller;

import com.space.space.model.Department;
import com.space.space.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")

public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @PutMapping("/department/{departmentOeCode}")
    public Department updateDepartment(@PathVariable String departmentOeCode, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentOeCode,department);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/department/{departmentId}")
    public Department getDepartmentById(@PathVariable String departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{departmentId}")
    public boolean deleteDepartmentById(@PathVariable String departmentId) {
        return departmentService.deleteDepartmentById(departmentId);
    }
}
