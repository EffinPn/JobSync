package org.example.retodam.repository;

import org.example.retodam.model.Empresa;
import org.example.retodam.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VacanteRepository extends JpaRepository<Vacante, Integer> {

    // Listar vacantes para ANDROID
    @Query("From Vacante v WHERE " +
            "(v.empresa.razon_social LIKE %:empresa% OR :empresa IS NULL) AND " +
            "(v.categoria.nombre LIKE %:categoria% OR :categoria IS NULL) AND " +
            "(v.descripcion LIKE %:descripcion% OR :descripcion IS NULL) AND " +
            "v.estatus = 'activa'")
    List<Vacante> listarVacantesFiltros(@Param("empresa") String empresa, @Param("categoria") String categoria, @Param("descripcion") String descripcion);
    List<Vacante> findByEmpresa_IdEmpresa(Integer empresa);
    Vacante findByIdVacante(Integer idVacante);
}
