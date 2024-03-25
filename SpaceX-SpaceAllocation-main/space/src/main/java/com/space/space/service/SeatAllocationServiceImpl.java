package com.space.space.service;

import com.space.space.model.*;
import com.space.space.repository.DepartmentRepo;
import com.space.space.repository.EmployeeRepo;
import com.space.space.repository.SeatRepo;
import com.space.space.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatAllocationServiceImpl implements SeatAllocationService{

    @Autowired
    private SeatRepo seatRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private TeamRepo teamRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Override
    public boolean allocateSeat(SeatAllocation seatAllocation) {
        if (seatRepo.findByEmployee(employeeRepo.findByEmployeeId(seatAllocation.getEmpId()))!=null){
            return false;
        }
        else{
            Employee employee = employeeRepo.findByEmployeeId(seatAllocation.getEmpId());
            Team team = employee.getTeam();
            Department department = employee.getDepartment();
            seatRepo.save(new Seat(seatAllocation.getSeatId(),employee,team,department));
        }
        return true;
    }
}
