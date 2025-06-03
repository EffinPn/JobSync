package org.example.retodam.repository;

import org.example.retodam.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    // Buscar por username para solicitudes y para comprobar si ya existe a la hora de registrar uno nuevo
    Optional<Usuario> findByUsername(String username);
    Usuario getByUsername(String username);

    // Buscar por correo para ver si el correo ya está registrado
    Optional<Usuario> findByEmail(String email);

    // Login de usuario por email y contraseña - necesario para almacernar el username para las solicitudes
    @Query("FROM Usuario u WHERE u.email = :email AND u.password = :password")
    Usuario getLogin(@Param("email") String email, @Param("password") String password);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

}
