package com.reto3.skate.repository.crud;

import org.springframework.data.repository.CrudRepository;
import com.reto3.skate.model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    
}
