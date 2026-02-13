package com.evasion_control.evasion_control.Infrastrucure.Repository;

import com.evasion_control.evasion_control.Infrastrucure.Entity.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlunoRepository extends MongoRepository<Aluno, String> {
}
