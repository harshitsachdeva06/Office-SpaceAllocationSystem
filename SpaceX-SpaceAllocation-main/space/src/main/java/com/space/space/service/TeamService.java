package com.space.space.service;

import com.space.space.exception.TeamNotFoundException;
import com.space.space.model.Team;
import com.space.space.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepo teamRepo;

    public List<Team> getAllTeams() {
        return teamRepo.findAll();
    }

    public Team addTeam(Team team) {
        return teamRepo.save(team);
    }

    public Team updateTeam(String teamOECode, Team team) {
        Team old_team = teamRepo.findById(teamOECode).get();
        old_team.setTeamName(team.getTeamName());
        old_team.setDepartment(team.getDepartment());
        old_team.setAVPEmpId(team.getAVPEmpId());
        return teamRepo.save(old_team);
    }

    public Team getTeamById(String teamId) {
        return teamRepo.findById(teamId).orElseThrow(() -> new TeamNotFoundException("Team with id: " + teamId + " not found."));
    }

    public boolean deleteTeamById(String teamId) {
        teamRepo.deleteById(teamId);
        return !teamRepo.existsById(teamId);
    }
}
