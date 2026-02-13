package com.evasion_control.evasion_control.Infrastrucure.Repository;

import com.evasion_control.evasion_control.Infrastrucure.Entity.Turma;
import com.evasion_control.evasion_control.Infrastrucure.Enums.Periodo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TurmaRepository extends MongoRepository<Turma, String> {
    long countByEmpresaIdAndMateriaAndPeriodo(String empresaId, String materia, Periodo periodo);
}
