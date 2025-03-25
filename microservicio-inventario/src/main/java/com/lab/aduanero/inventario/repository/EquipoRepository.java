package com.lab.aduanero.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lab.aduanero.inventario.model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    
    List<Equipo> findByEstado(String estado);
    
    // Consulta nativa para diagnóstico
    @Query(value = "SELECT * FROM equipment", nativeQuery = true)
    List<Equipo> findAllNative();
}