package com.lab.aduanero.inventario.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab.aduanero.inventario.model.Equipo;
import com.lab.aduanero.inventario.service.EquipoService;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public List<Equipo> listarEquipos() {
        return equipoService.listarTodos();
    }

    @GetMapping("/diagnostico")
    public String diagnostico() {
        long count = equipoService.listarTodos().size();
        return "Total equipos en BD: " + count;
    }

    @PostMapping
    public Equipo crearEquipo(@RequestBody Equipo equipo) {
        return equipoService.guardar(equipo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerEquipo(@PathVariable Long id) {
        return ResponseEntity.ok(equipoService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizarEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        return ResponseEntity.ok(equipoService.actualizar(id, equipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEquipo(@PathVariable Long id) {
        equipoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/disponibles")
    public List<Equipo> listarEquiposDisponibles() {
        return equipoService.listarDisponibles();
    }

    @PostMapping("/{id}/asignar")
    public ResponseEntity<Equipo> asignarUsuario(@PathVariable Long id, @RequestParam Long usuarioId) {
        return ResponseEntity.ok(equipoService.asignarUsuario(id, usuarioId));
    }
}