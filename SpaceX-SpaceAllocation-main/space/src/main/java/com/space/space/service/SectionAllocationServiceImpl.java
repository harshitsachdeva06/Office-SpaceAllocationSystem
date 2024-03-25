package com.space.space.service;

import com.space.space.model.Department;
import com.space.space.model.Seat;
import com.space.space.model.SectionAllocation;
import com.space.space.model.SpaceAllocation;
import com.space.space.repository.SeatRepo;
import com.space.space.repository.SectionAllocationRepo;
import com.space.space.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionAllocationServiceImpl implements SectionAllocationService{

    @Autowired
    private SectionAllocationRepo sectionAllocationRepo;
    @Autowired
    private SeatRepo seatRepo;

    @Autowired
    private TeamRepo teamRepo;

    public boolean allocateSection(SectionAllocation sectionAllocation){
        if (sectionAllocationRepo.findByTeamOECode(sectionAllocation.getTeamOECode())!=null)
        {
            return false;
        }
        else{
            sectionAllocationRepo.save(sectionAllocation);

            String[] seatStartId = sectionAllocation.getSeatIdStart().split("-");
            String[] seatEndId = sectionAllocation.getSeatIdEnd().split("-");
            int startId = Integer.parseInt(seatStartId[2]);
            int endId = Integer.parseInt(seatEndId[2]);
            for (int i = startId;i<= endId; i++) {
                String seatId = seatStartId[0]+"-"+seatStartId[1]+"-"+String.valueOf(i);
                Department department = teamRepo.findByTeamOECode(sectionAllocation.getTeamOECode()).getDepartment();
                seatRepo.save(new Seat(seatId,null,teamRepo.findByTeamOECode(sectionAllocation.getTeamOECode()),department));
            }
        }
        return true;
    }

}
