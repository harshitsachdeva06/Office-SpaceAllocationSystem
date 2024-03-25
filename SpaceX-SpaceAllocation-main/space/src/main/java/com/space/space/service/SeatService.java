package com.space.space.service;

import com.space.space.exception.SeatNotFoundException;
import com.space.space.model.Seat;
import com.space.space.repository.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepo seatRepo;

    public Seat addSeat(Seat seat) {
        return seatRepo.save(seat);
    }

    public List<Seat> getAllSeats() {
        return seatRepo.findAll();
    }

    public Seat getSeatById(String seatId) {
        return seatRepo.findById(seatId).orElseThrow(() -> new
                SeatNotFoundException("Seat with id : " + seatId + " not found"));
    }

    public Seat updateSeat(String seatId, Seat seat) {
        Seat oldSeat = seatRepo.findById(seatId).get();

        oldSeat.setEmployee(seat.getEmployee());
        oldSeat.setDepartment(seat.getDepartment());
        oldSeat.setTeam(seat.getTeam());

        return seatRepo.save(oldSeat);
    }

    public boolean deleteSeat(String seatId) {
        seatRepo.deleteById(seatId);
        return !seatRepo.existsById(seatId);
    }
}
