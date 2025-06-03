package org.example.retodam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SolicitudDTO {

    private int id_solicitud;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    private String archivo;
    private String comentarios;
    private Integer estado;

    private String username;
    private int id_vacante;
    private String nombre_vacante;



    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public int getId_vacante() {
        return id_vacante;
    }

    public void setId_vacante(int id_vacante) {
        this.id_vacante = id_vacante;
    }

    public String getNombre_vacante() {
        return nombre_vacante;
    }

    public void setNombre_vacante(String nombre_vacante) {
        this.nombre_vacante = nombre_vacante;
    }

    public SolicitudDTO(int id_solicitud, Date fecha, String archivo, String comentarios, Integer estado, String username, int id_vacante, String nombre_vacante) {
        this.id_solicitud = id_solicitud;
        this.fecha = fecha;
        this.archivo = archivo;
        this.comentarios = comentarios;
        this.estado = estado;
        this.username = username;
        this.id_vacante = id_vacante;
        this.nombre_vacante = nombre_vacante;
    }

    public SolicitudDTO() {
    }
}
