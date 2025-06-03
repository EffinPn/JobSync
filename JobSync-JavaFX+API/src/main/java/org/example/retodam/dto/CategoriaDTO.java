package org.example.retodam.dto;

public class CategoriaDTO {

    private String nombre;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaDTO(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaDTO() {
    }
}
