package com.lab.aduanero.inventario.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.aduanero.inventario.exception.ResourceNotFoundException;
import com.lab.aduanero.inventario.model.Equipo;
import com.lab.aduanero.inventario.repository.EquipoRepository;
import com.lab.aduanero.inventario.service.EquipoService;

@Service
@Transactional
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public List<Equipo> listarTodos() {
        System.out.println("Buscando todos los equipos...");
        List<Equipo> equipos = equipoRepository.findAllNative();
        System.out.println("Equipos encontrados: " + equipos.size());
        return equipos;
    }

    @Override
    public Equipo obtenerPorId(Long id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado con id: " + id));
    }

    @Override
    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public Equipo actualizar(Long id, Equipo equipo) {
        equipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado con id: " + id));
        equipo.setId(id);
        return equipoRepository.save(equipo);
    }

    @Override
    public void eliminar(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado con id: " + id));
        equipoRepository.delete(equipo);
    }

    @Override
    public List<Equipo> listarDisponibles() {
        return equipoRepository.findByEstado("DISPONIBLE");
    }

    @Override
    public Equipo asignarUsuario(Long equipoId, Long usuarioId) {
        Equipo equipo = obtenerPorId(equipoId);
        equipo.setUsuarioAsignadoId(usuarioId);
        equipo.setEstado("EN_USO");
        return equipoRepository.save(equipo);
    }
}