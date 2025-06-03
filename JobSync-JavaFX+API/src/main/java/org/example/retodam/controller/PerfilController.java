package org.example.retodam.controller;

import org.example.retodam.model.Perfil;
import org.example.retodam.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("perfiles")
public class PerfilController {

    @Autowired
    PerfilService perfilService;

}
