package org.example.retodam.service;


import org.example.retodam.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    Optional<Empresa> encontrarPorId(Integer id);
    List<Empresa> getAll();
    String saveEmpresa(Empresa empresa);
    String deleteEmpresa(Integer id);
}
