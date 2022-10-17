package com.reto3.skate.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.skate.model.Reservation;
import com.reto3.skate.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getReservationAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservationId(Integer id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public List<Reservation> ReservationStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    public List<Reservation> ReservationTiempo(Date fechaInicial, Date fechaFinal){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore (fechaInicial, fechaFinal);
    }
    public List<Object[]> reporteClientes(){
        return reservationCrudRepository.reporteClientes();
    }
}
