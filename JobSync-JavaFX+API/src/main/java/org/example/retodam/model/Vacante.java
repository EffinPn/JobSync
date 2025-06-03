package org.example.retodam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vacantes")
public class Vacante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vacante")
    private int idVacante;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private Double salario;

    @Enumerated(EnumType.STRING)
    private EstadoVacante estatus;
    private boolean destacado;
    private String imagen;
    private String detalles;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonBackReference("categoria-vacantes")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    @JsonBackReference("empresa-vacantes")
    private Empresa empresa;

    @OneToMany (mappedBy = "vacante")
    @JsonManagedReference("vacante-solicitudes")
    private List<Solicitud> solicitudes;


    public int getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(int id_vacante) {
        this.idVacante = id_vacante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public EstadoVacante getEstatus() {
        return estatus;
    }

    public void setEstatus(EstadoVacante estatus) {
        this.estatus = estatus;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
