package com.reto3.skate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.skate.model.Reservation;
import com.reto3.skate.repository.ReservationRepository;



@Service
public class  ReservationServices {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getReservationAll(){
        return reservationRepository.getReservationAll();
    }
    public Optional<Reservation> getReservationId(Integer id){
        return reservationRepository.getReservationId(id);
    }
    public Reservation save (Reservation reservation){
        if (reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservation1 = reservationRepository.getReservationId(reservation.getIdReservation());
            if (reservation1.isEmpty()){
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }
}
