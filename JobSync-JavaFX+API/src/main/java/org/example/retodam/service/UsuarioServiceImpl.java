package org.example.retodam.service;

import org.example.retodam.dto.UsuarioDTO;
import org.example.retodam.model.Usuario;
import org.example.retodam.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    // Añadir usuario para ANDROID
    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Buscar usuario para solicitudes y para ver si username ya existe
    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario getByUsername(String username) {
        return usuarioRepository.getByUsername(username);
    }

    // Buscar por email para ver si ya existe
    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    // Login usuario
    @Override
    public Usuario getLogin(UsuarioDTO usuarioDTO) {
        return usuarioRepository.getLogin(usuarioDTO.getEmail(), usuarioDTO.getPassword());
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public String saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Exito actualizando";
    }
}
