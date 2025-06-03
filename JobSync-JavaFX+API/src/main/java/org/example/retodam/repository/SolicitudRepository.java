package org.example.retodam.repository;

import org.example.retodam.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

    // Consultar solicitudes por usuario ANDROID
    @Query("FROM Solicitud s WHERE s.usuario.username = :username")
    List<Solicitud> getSolicitudesUsuario(@Param("username") String username);

    List<Solicitud> findByVacante_IdVacante(Integer id);
}
