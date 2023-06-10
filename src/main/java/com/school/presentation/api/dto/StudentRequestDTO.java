package com.school.presentation.api.dto;

import com.school.business.entity.Student;
import com.school.business.entity.builder.StudentBuilder;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

public class StudentRequestDTO {

    @CPF
    private String cpf;

    @NotBlank
    private String name;

    @NotBlank
    private String emailAddress;

    public Student toEntity() {
        return new StudentBuilder()
                .withNameCPFEmail(this.name, this.cpf, this.emailAddress)
                .build();
    }
}
