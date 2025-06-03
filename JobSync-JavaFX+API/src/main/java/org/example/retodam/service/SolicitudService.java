package org.example.retodam.service;

import org.example.retodam.dto.SolicitudDTO;
import org.example.retodam.model.Solicitud;

import java.util.List;

public interface SolicitudService {

    // Añadir solicitud ANDROID
    Solicitud mandarSolicitud(SolicitudDTO solicitudDTO);

    // Consultar solicitudes por usuario ANDROID
    List<Solicitud> getSolicitudesUsuario(String username);
    List<SolicitudDTO> solicitudesToDTO(List<Solicitud> solicitudes);
    List<Solicitud> obtenerSolicitudes();
    // Eliminar solicitud ANDROID
    boolean eliminarSolicitud(int id);
    List<Solicitud> obtenerSolicitudesVacanteId(int id);
}
