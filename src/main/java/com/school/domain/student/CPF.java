package com.school.domain.student;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class CPF {

    private String number;

    public CPF(String number) {
        if (StringUtils.isBlank(number) ||
                !number.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.number = number;
    }
}
