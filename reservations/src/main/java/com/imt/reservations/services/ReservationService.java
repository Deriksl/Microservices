package com.imt.reservations.services;

import com.imt.reservations.model.Reservation;
import com.imt.reservations.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public List<Reservation> listar() {
        return repository.findAll();
    }

    public Reservation guardar(Reservation reservation) {
        return repository.save(reservation);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
