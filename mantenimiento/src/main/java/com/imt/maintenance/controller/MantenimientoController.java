package com.imt.maintenance.controller;

import com.imt.maintenance.model.Mantenimiento;
import com.imt.maintenance.service.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mantenimientos")
public class MantenimientoController {
    @Autowired
    private MantenimientoService service;

    @GetMapping
    public List<Mantenimiento> obtenerTodos() {
        return service.listar();
    }

    @PostMapping
    public Mantenimiento crear(@RequestBody Mantenimiento mantenimiento) {
        return service.guardar(mantenimiento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}