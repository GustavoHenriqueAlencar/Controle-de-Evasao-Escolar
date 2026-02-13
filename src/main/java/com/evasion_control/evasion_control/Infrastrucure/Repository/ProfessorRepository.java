package com.evasion_control.evasion_control.Infrastrucure.Repository;

import com.evasion_control.evasion_control.Infrastrucure.Entity.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfessorRepository extends MongoRepository<Professor, String> {
}
