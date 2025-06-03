package org.example.retodam.controller;

import org.example.retodam.dto.VacanteDTO;
import org.example.retodam.model.Vacante;
import org.example.retodam.service.VacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("vacantes")
public class VacanteController {

    @Autowired
    VacanteService vacanteService;


    @GetMapping("/getall")
    public ResponseEntity<List<Vacante>> getAll() {
        return new ResponseEntity<>(vacanteService.consultarVacantes(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public String crear(@RequestBody VacanteDTO vacantedto) {
        vacanteService.saveVacante(vacanteService.crearVacanteDesdeDTO(vacantedto));
        return "éxito agregando la vacante";
    }

    @PatchMapping("/actualizar")
    public String actualizar(@RequestBody VacanteDTO vacantedto) {
        vacanteService.saveVacante(vacanteService.editarVacanteDesdeDTO(vacantedto));
        return "éxito agregando la vacante";
    }

    // Endpoint para buscar Vacantes con filtros ANDROID
    @GetMapping("/buscarFiltros")
    public ResponseEntity<List<Vacante>> listarVacantesFiltros(@RequestParam(required = false) String empresa,
                                                               @RequestParam(required = false) String categoria,
                                                               @RequestParam(required = false) String descripcion){

        List<Vacante> vacantes = vacanteService.listarVacantesFiltros(empresa, categoria, descripcion);

        List<VacanteDTO> vacantesDTO = vacanteService.vacantesToDTO(vacantes);

        if (!vacantesDTO.isEmpty()) {
            return new ResponseEntity<>(vacantes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping ("porEmpresa")
    ResponseEntity<List<Vacante>> listarPorEmpresa(@RequestBody Integer id) {
        return new ResponseEntity<>(vacanteService.consultarPorIdEmpresa(id), HttpStatus.OK);
    }
}
