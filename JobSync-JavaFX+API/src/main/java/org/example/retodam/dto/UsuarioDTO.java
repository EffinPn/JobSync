package org.example.retodam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UsuarioDTO {

    private String username;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd") // formato de fecha (año-mes-día)
    private Date fecha_registro;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public UsuarioDTO(String username, String nombre, String apellidos, String email, String password, Date fecha_registro) {
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.fecha_registro = fecha_registro;
    }

    public UsuarioDTO() {
    }
}
