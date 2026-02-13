package com.evasion_control.evasion_control.Infrastrucure.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "professores")
@Data
@Getter
@Setter
public class Professor {

    @Id
    private String id;

    private String nome;

}
