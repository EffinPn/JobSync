package org.example.retodam.repository;

import org.example.retodam.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Optional<Categoria> findById(Integer id);
    void deleteCategoriaByIdCategoria(Integer id);
}
