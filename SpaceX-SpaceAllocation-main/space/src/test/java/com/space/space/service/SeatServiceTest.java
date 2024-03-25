package com.space.space.service;

import com.space.space.model.Department;
import com.space.space.model.Employee;
import com.space.space.model.Seat;
import com.space.space.model.Team;
import com.space.space.repository.SeatRepo;
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
class SeatServiceTest {
    @Autowired
    SeatService seatService;

    @MockBean
    SeatRepo seatRepo;

    @Test
    void addSeat() {
        Seat seat = new Seat("L4", 1, new Employee(), new Team(), new Department());
        Mockito.when(seatRepo.save(seat)).thenReturn(seat);
        seatService.addSeat(seat);
        Assertions.assertThat(seat.getSeatId()).isEqualTo("L4");
    }

    @Test
    void getAllSeats() {
        Seat seat = new Seat("L4", 1, new Employee(), new Team(), new Department());
        List<Seat> seatList = new ArrayList<>();
        seatList.add(seat);

        Mockito.when(seatRepo.findAll()).thenReturn(seatList);

        List<Seat> seats = seatService.getAllSeats();

        Assertions.assertThat(seats.size()).isGreaterThan(0);
    }

    @Test
    void getSeatById() {
        Seat seat = new Seat("L4", 1, new Employee(), new Team(), new Department());
        Mockito.when(seatRepo.findById("L4")).thenReturn(Optional.of(seat));

        Seat found = seatService.getSeatById("L4");

        Assertions.assertThat(found.getSeatId()).isEqualTo("L4");
    }

    @Test
    void updateSeat() {
        Seat seat = new Seat("L4", 1, new Employee(), new Team(), new Department());
        Mockito.when(seatRepo.findById("L4")).thenReturn(Optional.of(seat));
        Mockito.when(seatRepo.save(seat)).thenReturn(seat);

        Seat updated = seatService.getSeatById("L4");

        Assertions.assertThat(updated.getSeatId()).isEqualTo("L4");
    }

    @Test
    void deleteSeat() {
        Mockito.when(seatRepo.existsById("L4")).thenReturn(false);
        Assertions.assertThat(seatService.deleteSeat("L4")).isTrue();
    }
}