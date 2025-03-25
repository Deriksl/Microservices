package com.lab.aduanero.inventario.service;

import java.util.List;

import com.lab.aduanero.inventario.model.Equipo;

public interface EquipoService {
    List<Equipo> listarTodos();
    Equipo obtenerPorId(Long id);
    Equipo guardar(Equipo equipo);
    Equipo actualizar(Long id, Equipo equipo);
    void eliminar(Long id);
    List<Equipo> listarDisponibles();
    Equipo asignarUsuario(Long equipoId, Long usuarioId);
}