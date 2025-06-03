package org.example.retodam.service;

import org.example.retodam.dto.VacanteDTO;
import org.example.retodam.model.Categoria;
import org.example.retodam.model.Empresa;
import org.example.retodam.model.Vacante;
import org.example.retodam.repository.CategoriaRepository;
import org.example.retodam.repository.EmpresaRepository;
import org.example.retodam.repository.VacanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacanteServiceImpl implements VacanteService {

    @Autowired
    VacanteRepository vacanteRepository;
    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

    // Listar vacantes con filtros ANDROID
    @Override
    public List<Vacante> listarVacantesFiltros(String empresa, String categoria, String descripcion) {
        return vacanteRepository.listarVacantesFiltros(empresa,categoria,descripcion);
    }

    @Override
    public String saveVacante(Vacante vacante) {
        vacanteRepository.save(vacante);
        return "Exito desde la API";
    }


    // Para convertir lo de la BBDD a DTO
    @Override
    public List<VacanteDTO> vacantesToDTO(List<Vacante> vacantes) {
        List<VacanteDTO> vacantesDTO = new ArrayList<>();

        // convertimos cada vacante a DTO
        for(Vacante vacante : vacantes){
            VacanteDTO vacanteDTO = new VacanteDTO(
                    vacante.getNombre(),
                    vacante.getDescripcion(),
                    vacante.getFecha(),
                    vacante.getSalario(),
                    vacante.getEstatus(),
                    vacante.isDestacado(),
                    vacante.getImagen(),
                    vacante.getDetalles(),
                    vacante.getCategoria().getIdCategoria(),
                    vacante.getEmpresa().getId_empresa()
            );

            vacantesDTO.add(vacanteDTO);
        }
        return vacantesDTO;
    }

    @Override
    public List<Vacante> consultarVacantes() {
        return vacanteRepository.findAll();
    }




    // Buscar vacante para solicitud
    @Override
    public Vacante getById(int id) {
        return vacanteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vacante> consultarPorIdEmpresa(Integer id) {
        return vacanteRepository.findByEmpresa_IdEmpresa(id);
    }

    @Override
    public Vacante editarVacanteDesdeDTO(VacanteDTO dto) {
        Vacante vacante = vacanteRepository.findByIdVacante(dto.getId());
        vacante.setNombre(dto.getNombre());
        vacante.setDescripcion(dto.getDescripcion());
        vacante.setSalario(dto.getSalario());
        vacante.setDetalles(dto.getDetalles());
        vacante.setEstatus(dto.getEstatus());
        return vacante;
    }

    @Override
    public Vacante crearVacanteDesdeDTO(VacanteDTO dto) {
        Vacante vacante = new Vacante();
        vacante.setIdVacante(0);
        vacante.setNombre(dto.getNombre());
        vacante.setDescripcion(dto.getDescripcion());
        vacante.setSalario(dto.getSalario());
        vacante.setFecha(dto.getFecha());
        vacante.setDetalles(dto.getDetalles());
        vacante.setEstatus(dto.getEstatus());
        vacante.setImagen(dto.getImagen());
        vacante.setDestacado(dto.isDestacado());
        vacante.setEmpresa(empresaRepository.findByIdEmpresa(dto.getId_empresa()).orElseThrow());
        vacante.setCategoria(categoriaRepository.findById(dto.getId_categoria()).orElseThrow());
        return vacante;
    }

    @Override
    public Vacante encontrarPorId(Integer id) {
        return vacanteRepository.findByIdVacante(id);
    }

}
