package com.space.space.service;

import com.space.space.model.Department;
import com.space.space.model.Team;
import com.space.space.repository.TeamRepo;
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
class TeamServiceTest {
    @Autowired
    private TeamService teamService;

    @MockBean
    private TeamRepo teamRepo;

    @Test
    void getAllTeams() {
        Team team = new Team("MBLE 86", "Beacon", 123456, new Department());

        List<Team> teamList = new ArrayList<>();
        teamList.add(team);

        Mockito.when(teamRepo.findAll()).thenReturn(teamList);

        List<Team> teams = teamService.getAllTeams();

        Assertions.assertThat(teams.size()).isGreaterThan(0);
    }

    @Test
    void addTeam() {
        Team team = new Team("MBLE 86", "Beacon", 123456, new Department());
        Mockito.when(teamRepo.save(team)).thenReturn(team);
        teamService.addTeam(team);
        Assertions.assertThat(team.getAVPEmpId()).isEqualTo(123456);
    }

    @Test
    void updateTeam() {
        Team team = new Team("MBLE 86", "Beacon", 123456, new Department());
        Mockito.when(teamRepo.save(team)).thenReturn(team);
        Mockito.when(teamRepo.findById("MBLE 86")).thenReturn(Optional.of(team));

        Team updated = teamService.updateTeam("MBLE 86", team);
        Assertions.assertThat(updated.getAVPEmpId()).isEqualTo(123456);
    }

    @Test
    void getTeamById() {
        Team team = new Team("MBLE 86", "Beacon", 123456, new Department());
        Mockito.when(teamRepo.findById("MBLE 86")).thenReturn(Optional.of(team));

        Team found = teamService.getTeamById("MBLE 86");
        Assertions.assertThat(found.getAVPEmpId()).isEqualTo(123456);
    }

    @Test
    void deleteTeamById() {
        Mockito.when(teamRepo.existsById("MBLE 86")).thenReturn(false);
        Assertions.assertThat(teamService.deleteTeamById("MBLE 86")).isTrue();
    }
}