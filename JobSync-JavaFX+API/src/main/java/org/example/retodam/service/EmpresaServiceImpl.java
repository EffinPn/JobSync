package org.example.retodam.service;

import org.example.retodam.model.Empresa;
import org.example.retodam.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    public Optional<Empresa> encontrarPorId(Integer id) {
        return empresaRepository.findByIdEmpresa(id);
    }

    @Override
    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }

    @Override
    public String saveEmpresa(Empresa empresa) {
        empresaRepository.save(empresa);
        return "Exito actualizando";
    }

    @Override
    @Transactional
    public String deleteEmpresa(Integer id) {
        empresaRepository.deleteEmpresaByIdEmpresa(id);
        return "Exito borrando";
    }
}
