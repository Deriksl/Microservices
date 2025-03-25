package com.imt.maintenance.service;

import com.imt.maintenance.model.Mantenimiento;
import com.imt.maintenance.repository.MantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MantenimientoService {
    @Autowired
    private MantenimientoRepository repository;

    public List<Mantenimiento> listar() {
        return repository.findAll();
    }

    public Mantenimiento guardar(Mantenimiento mantenimiento) {
        return repository.save(mantenimiento);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}