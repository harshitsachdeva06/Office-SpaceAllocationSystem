package com.space.space.repository;

import com.space.space.model.SectionAllocation;
import com.space.space.model.SpaceAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionAllocationRepo extends JpaRepository<SectionAllocation,Integer> {

    SectionAllocation findByTeamOECode(String teamOECode);
}
