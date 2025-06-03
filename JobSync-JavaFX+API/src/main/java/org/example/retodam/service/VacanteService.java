package org.example.retodam.service;

import org.example.retodam.dto.VacanteDTO;
import org.example.retodam.model.Vacante;

import java.util.List;

public interface VacanteService {

    // Listar vacantes con filtros ANDROID
    List<Vacante> listarVacantesFiltros(String empresa, String categoria, String descripcion);
    String saveVacante(Vacante vacante);
    List<VacanteDTO> vacantesToDTO(List<Vacante> vacantes);
    List<Vacante> consultarVacantes();
    // buscar vacante para solicitud
    Vacante getById(int id);
    List<Vacante> consultarPorIdEmpresa(Integer id);
    Vacante editarVacanteDesdeDTO(VacanteDTO dto);
    Vacante crearVacanteDesdeDTO(VacanteDTO dto);
    Vacante encontrarPorId(Integer id);
}
