package org.example.retodam.controller;

import org.example.retodam.model.Categoria;
import org.example.retodam.model.Empresa;
import org.example.retodam.model.Usuario;
import org.example.retodam.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/getall")
    public ResponseEntity<List<Categoria>> getAll() {
        return new ResponseEntity<>(categoriaService.encontrarTodas(), HttpStatus.OK);
    }

    @PatchMapping("/actualizar")
    public String actualizar(@RequestBody Categoria categoria) {
        categoriaService.saveCategoria(categoria);
        return "éxito agregando la vacante";
    }

    @DeleteMapping("/borrar/{id}")
    public String borrar(@PathVariable Integer id) {
        categoriaService.deleteCategoria(id);
        return "Exito borrando";
    }
}
