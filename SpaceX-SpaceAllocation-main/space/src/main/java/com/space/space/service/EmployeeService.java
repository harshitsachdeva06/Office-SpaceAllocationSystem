package com.space.space.service;

import com.space.space.exception.EmployeeNotFoundException;
import com.space.space.model.Employee;
import com.space.space.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeRepo.findById(employeeId).orElseThrow(() -> new
                EmployeeNotFoundException("Employee with id : " + employeeId + " not found"));
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(int employeeId, Employee employee) {
        Employee old_employee = employeeRepo.findById(employeeId).get();

        old_employee.setEmployeeName(employee.getEmployeeName());
        old_employee.setDepartment(employee.getDepartment());
        old_employee.setDesignation(employee.getDesignation());
        old_employee.setPassword(employee.getPassword());
        old_employee.setOECode(employee.getOECode());
        old_employee.setReportsTo(employee.getReportsTo());
        old_employee.setTeam(employee.getTeam());

        return employeeRepo.save(old_employee);
    }

    public boolean deleteEmployee(int employeeId) {
        employeeRepo.deleteById(employeeId);
        return !employeeRepo.existsById(employeeId);
    }

}
