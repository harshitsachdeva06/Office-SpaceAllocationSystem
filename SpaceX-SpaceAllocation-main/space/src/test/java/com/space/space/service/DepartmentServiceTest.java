package com.space.space.service;

import com.space.space.model.Department;
import com.space.space.repository.DepartmentRepo;
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
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepo departmentRepo;

    @Test
    void addDepartment() {
        Department department = new Department("MBLE", "GTS", 123456);
        Mockito.when(departmentRepo.save(department)).thenReturn(department);
        departmentService.addDepartment(department);
        Assertions.assertThat(department.getVPEmpId()).isGreaterThan(0);
    }

    @Test
    void updateDepartment(){
        Department department = new Department("MBLE", "GTS", 123456);

        Mockito.when(departmentRepo.findById("MBLE")).thenReturn(Optional.of(department));
        Mockito.when(departmentRepo.save(department)).thenReturn(department);

        Department updated = departmentService.updateDepartment("MBLE",department);
        Assertions.assertThat(updated.getName()).isEqualTo("GTS");
    }

    @Test
    void getAllDepartments() {
        Department department = new Department("MBLE", "GTS", 123456);

        List<Department> departments = new ArrayList<>();
        departments.add(department);

        Mockito.when(departmentRepo.findAll()).thenReturn(departments);
        List<Department> departmentList = departmentService.getAllDepartments();

        Assertions.assertThat(departmentList.size()).isGreaterThan(0);
    }

    @Test
    void getDepartmentById() {
        Department department = new Department("MBLE", "GTS", 123456);

        Mockito.when(departmentRepo.findById("MBLE")).thenReturn(Optional.of(department));
        Department found = departmentService.getDepartmentById("MBLE");

        Assertions.assertThat(found.getName()).isEqualTo("GTS");
    }

    @Test
    void deleteDepartmentById() {
        Mockito.when(departmentRepo.existsById("MBLE")).thenReturn(false);

        Assertions.assertThat(departmentService.deleteDepartmentById("MBLK")).isTrue();
    }
}