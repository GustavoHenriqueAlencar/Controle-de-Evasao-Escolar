package com.evasion_control.evasion_control.bService;

import com.evasion_control.evasion_control.Infrastrucure.Entity.Empresa;
import com.evasion_control.evasion_control.Infrastrucure.Repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpresaService
{

    private EmpresaRepository empresaRepository;

    public Empresa createEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> findAllEmpresas() {
        return empresaRepository.findAll();
    }

}
