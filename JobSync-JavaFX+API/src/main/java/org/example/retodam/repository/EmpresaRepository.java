package org.example.retodam.repository;

import org.example.retodam.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    Optional<Empresa> findByIdEmpresa(Integer id);
    void deleteEmpresaByIdEmpresa(int idEmpresa);
}
