package com.evasion_control.evasion_control.Infrastrucure.Repository;

import com.evasion_control.evasion_control.Infrastrucure.Entity.Matricula;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MatriculaRepository extends MongoRepository<Matricula, String> {

    List<Matricula> findByTurmaId(String turmaId);

}
