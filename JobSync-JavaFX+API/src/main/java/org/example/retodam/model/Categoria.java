package org.example.retodam.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "id_categoria")
    private int idCategoria;
    private String nombre;
    private String descripcion;

    @OneToMany (mappedBy = "categoria", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("categoria-vacantes")
    private List<Vacante> vacantes;


    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int id_categoria) {
        this.idCategoria = id_categoria;
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

    public List<Vacante> getVacantes() {
        return vacantes;
    }

    public void setVacantes(List<Vacante> vacantes) {
        this.vacantes = vacantes;
    }
}
