package com.evasion_control.evasion_control.Controller;

import com.evasion_control.evasion_control.Infrastrucure.Entity.Empresa;
import com.evasion_control.evasion_control.bService.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    // Criar nova empresa
    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa) {
        Empresa savedEmpresa = empresaService.createEmpresa(empresa);
        return ResponseEntity.ok(savedEmpresa);
    }

    // Listar todas as empresas
    @GetMapping
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        List<Empresa> empresas = empresaService.findAllEmpresas();
        return ResponseEntity.ok(empresas);
    }
}
