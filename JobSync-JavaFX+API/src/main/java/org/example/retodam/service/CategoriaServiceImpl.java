package org.example.retodam.service;


import jakarta.transaction.Transactional;
import org.example.retodam.model.Categoria;
import org.example.retodam.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public Optional<Categoria> encontrarPorId(int id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public List<Categoria> encontrarTodas() {
        return categoriaRepository.findAll();
    }

    @Override
    public String saveCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
        return "Exito actualizando";
    }

    @Override
    @Transactional
    public String deleteCategoria(Integer id) {
        categoriaRepository.deleteCategoriaByIdCategoria(id);
        return "Exito borrando";
    }
}
