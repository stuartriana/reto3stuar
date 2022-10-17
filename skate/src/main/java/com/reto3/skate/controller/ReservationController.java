package com.reto3.skate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto3.skate.model.Reservation;
import com.reto3.skate.reportes.ContadorClientes;
import com.reto3.skate.reportes.StatusReservas;
import com.reto3.skate.services.ReservationServices;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin (origins ="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})

public class ReservationController {
      
    @Autowired
    private ReservationServices reservationServices;

    @GetMapping("/all")
    public List<Reservation> getReservationAll(){
        return reservationServices.getReservationAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getReservationId(@PathVariable("id") Integer id){
        return reservationServices.getReservationId(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationServices.save(reservation);
    }
    @GetMapping("/report-status")
    public StatusReservas getStatusReservas(){
        return reservationServices.ReservationStatus();
    }
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservasTiempo(@PathVariable("dateOne")
            String fechaInicial, @PathVariable("dateTwo") String fechaFinal){
                return reservationServices.ReservationTiempo(fechaInicial, fechaFinal);
        }
    @GetMapping("/report-clients")
    public List<ContadorClientes> getClientes(){
        return reservationServices.reporteClientes();
    }

}
