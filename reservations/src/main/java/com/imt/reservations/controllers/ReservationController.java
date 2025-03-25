package com.imt.reservations.controllers;

import com.imt.reservations.model.Reservation;
import com.imt.reservations.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
class ReservationController {
    @Autowired
    private ReservationService service;

    @GetMapping
    public List<Reservation> obtenerTodos() {
        return service.listar();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public Reservation crear(@RequestBody Reservation reservation) {
        return service.guardar(reservation);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}