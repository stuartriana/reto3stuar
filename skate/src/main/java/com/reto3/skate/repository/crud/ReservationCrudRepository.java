package com.reto3.skate.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reto3.skate.model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    public List<Reservation> findAllByStatus(String status);

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date fechaInicio, Date fechaFin);

    @Query("SELECT c.client, COUNT(c.client) from Reservation  AS c  group by c.client order by COUNT(c.client)DESC ")
    public List<Object[]> reporteClientes();

}
