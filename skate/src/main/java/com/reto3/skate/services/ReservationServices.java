package com.reto3.skate.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.skate.model.Client;
import com.reto3.skate.model.Reservation;
import com.reto3.skate.reportes.ContadorClientes;
import com.reto3.skate.reportes.StatusReservas;
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
    public StatusReservas ReservationStatus(){
        List<Reservation> completed = reservationRepository.ReservationStatus("completed");
        List<Reservation> cancelled = reservationRepository.ReservationStatus("cancelled");

        return new StatusReservas(completed.size(), cancelled.size());
    }
    public List<Reservation> ReservationTiempo(String fechaInicial,String fechaFinal){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaUno = new Date();
        Date fechaDos = new Date();

        try {
            fechaUno = parser.parse(fechaInicial);
            fechaDos = parser.parse(fechaFinal);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (fechaUno.before(fechaDos)) {
            return reservationRepository.ReservationTiempo(fechaUno, fechaDos);
        } else {
            return new ArrayList<>();
        }
    }
    public List<ContadorClientes> reporteClientes() {        
        List<ContadorClientes> resultado = new ArrayList<>();
        List<Object[]> reporte = reservationRepository.reporteClientes();
        System.out.println(reporte);
        for (int i = 0; i < reporte.size(); i++) {
            resultado.add(new ContadorClientes((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return resultado;
    }


}
