package org.example.retodam.service;

import org.example.retodam.dto.SolicitudDTO;
import org.example.retodam.model.Solicitud;
import org.example.retodam.model.Usuario;
import org.example.retodam.model.Vacante;
import org.example.retodam.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    SolicitudRepository solicitudRepository;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    VacanteService vacanteService;


    // Añadir solicitud ANDROID
    @Override
    public Solicitud mandarSolicitud(SolicitudDTO solicitudDTO) {
        Usuario usuario = usuarioService.getByUsername(solicitudDTO.getUsername());
        
        Vacante vacante = vacanteService.getById(solicitudDTO.getId_vacante());

        // Crear la entidad Solicitud a partir del DTO
        Solicitud solicitud = new Solicitud();
        solicitud.setFecha(new Date());
        solicitud.setArchivo(solicitudDTO.getArchivo());
        solicitud.setComentarios(solicitudDTO.getComentarios());
        solicitud.setEstado(solicitudDTO.getEstado());
        solicitud.setUsuario(usuario);
        solicitud.setVacante(vacante);

        // Guardar la solicitud en la base de datos
        return solicitudRepository.save(solicitud);

    }

    // Consultar solicitudes por usuario ANDROID
    @Override
    public List<Solicitud> getSolicitudesUsuario(String username) {
        return solicitudRepository.getSolicitudesUsuario(username);
    }

    @Override
    public List<SolicitudDTO> solicitudesToDTO(List<Solicitud> solicitudes) {
        List<SolicitudDTO> solicitudesDTO = new ArrayList<>();

        for(Solicitud solicitud : solicitudes){
            SolicitudDTO solicitudDTO = new SolicitudDTO(
                    solicitud.getId_solicitud(),
                    solicitud.getFecha(),
                    solicitud.getArchivo(),
                    solicitud.getComentarios(),
                    solicitud.getEstado(),
                    solicitud.getUsuario().getUsername(),
                    solicitud.getVacante().getIdVacante(),
                    solicitud.getVacante().getNombre()
            );

            solicitudesDTO.add(solicitudDTO);
        }
        return solicitudesDTO;
    }

    @Override
    public List<Solicitud> obtenerSolicitudes() {
        return solicitudRepository.findAll();
    }

    // Eliminar solicitud por ID ANDROID
    @Override
    public boolean eliminarSolicitud(int id){
        if (solicitudRepository.existsById(id)) {
            solicitudRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Solicitud> obtenerSolicitudesVacanteId(int id) {
        return solicitudRepository.findByVacante_IdVacante(id);
    }
}
