package org.example.retodam.service;

import org.example.retodam.dto.UsuarioDTO;
import org.example.retodam.model.Usuario;

import java.util.List;
import java.util.Optional;


public interface UsuarioService {

    // Añadir usuario para ANDROID
    Usuario registrarUsuario(Usuario usuario);

    // Buscar usuario para añadir la solicitud y para comprobar si ya existe el username
    Optional<Usuario> findByUsername(String username);
    Usuario getByUsername(String username);

    // Buscar por correo para comprobar si ya existe
    Optional<Usuario> findByEmail(String email);

    // Login de usuario
    Usuario getLogin(UsuarioDTO usuarioDTO);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    List<Usuario> getAll();
    String saveUsuario(Usuario usuario);
}
