package com.evasion_control.evasion_control.Infrastrucure.Repository;

import com.evasion_control.evasion_control.Infrastrucure.Entity.Registro;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface RegistroRepository extends MongoRepository<Registro, String> {
    boolean existsByTurmaIdAndDataRegistro(String turmaId, LocalDate dataRegistro);

    List<Registro> findByDataRegistroBetween(LocalDate inicio, LocalDate fim);
}
