package org.example.retodam.controller;

import org.example.retodam.dto.UsuarioDTO;
import org.example.retodam.dto.VacanteDTO;
import org.example.retodam.model.Usuario;
import org.example.retodam.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/getall")
    public ResponseEntity<List<Usuario>> getAll(){
        return new ResponseEntity<>(usuarioService.getAll(), HttpStatus.OK);
    }
    @PatchMapping("/actualizar")
    public String actualizar(@RequestBody Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return "éxito agregando el usuario";
    }
}
