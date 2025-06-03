package org.example.retodam.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.example.retodam.model.EstadoVacante;

import java.util.Date;


public class VacanteDTO {
    private int id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private Double salario;

    @Enumerated(EnumType.STRING)
    private EstadoVacante estatus;

    private boolean destacado;
    private String imagen;
    private String detalles;

    private int id_categoria;
    private int id_empresa;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public EstadoVacante getEstatus() {
        return estatus;
    }

    public void setEstatus(EstadoVacante estatus) {
        this.estatus = estatus;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public VacanteDTO(String nombre, String descripcion, Date fecha, Double salario, EstadoVacante estatus, boolean destacado, String imagen, String detalles, int id_categoria, int id_empresa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.salario = salario;
        this.estatus = estatus;
        this.destacado = destacado;
        this.imagen = imagen;
        this.detalles = detalles;
        this.id_categoria = id_categoria;
        this.id_empresa = id_empresa;
    }

    public VacanteDTO() {
    }
}
