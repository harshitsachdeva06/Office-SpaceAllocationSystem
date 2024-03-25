package com.space.space.service;

import com.space.space.model.Department;
import com.space.space.model.Employee;
import com.space.space.model.Seat;
import com.space.space.model.Team;
import com.space.space.repository.EmployeeRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepo employeeRepo;

    @Test
    void getAllEmployee() {
        Employee employee = new Employee(123, "Aashi", 1234, "Analyst", "MBLE 86", "aashi", new Team(), new Department(), new Seat());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);

        Mockito.when(employeeRepo.findAll()).thenReturn(employeeList);

        List<Employee> employees = employeeService.getAllEmployee();

        Assertions.assertThat(employees.size()).isGreaterThan(0);
    }

    @Test
    void getEmployeeById() {
        Employee employee = new Employee(123, "Aashi", 1234, "Analyst", "MBLE 86", "aashi", new Team(), new Department(), new Seat());
        Mockito.when(employeeRepo.findById(123)).thenReturn(Optional.of(employee));

        Employee found = employeeService.getEmployeeById(123);
        Assertions.assertThat(found.getEmployeeId()).isEqualTo(123);
    }

    @Test
    void addEmployee() {
        Employee employee = new Employee(123, "Aashi", 1234, "Analyst", "MBLE 86", "aashi", new Team(), new Department(), new Seat());
        Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
        employeeService.addEmployee(employee);
        Assertions.assertThat(employee.getEmployeeId()).isEqualTo(123);
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee(123, "Aashi", 1234, "Analyst", "MBLE 86", "aashi", new Team(), new Department(), new Seat());
        Mockito.when(employeeRepo.findById(123)).thenReturn(Optional.of(employee));
        Mockito.when(employeeRepo.save(employee)).thenReturn(employee);

        Employee updated = employeeService.getEmployeeById(123);

        Assertions.assertThat(updated.getEmployeeId()).isEqualTo(123);
    }

    @Test
    void deleteEmployee() {
        Mockito.when(employeeRepo.existsById(123)).thenReturn(false);
        Assertions.assertThat(employeeService.deleteEmployee(123)).isTrue();
    }
}