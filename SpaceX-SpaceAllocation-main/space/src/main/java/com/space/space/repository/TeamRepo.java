package com.space.space.repository;

import com.space.space.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team,String> {
    Team findByTeamOECode(String teamOECode);
}
