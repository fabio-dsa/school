package com.school.domain.student;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Builder
@Getter
public class Phone {

    private String ddd;

    private String number;

    public Phone(String ddd, String number) {
        if (!isValidDDD(ddd)) {
            throw new IllegalArgumentException("DDD inválido");
        }

        if (!isValidPhoneNumber(number)) {
            throw new IllegalArgumentException("Número de telefone inválido");
        }

        this.ddd = ddd;
        this.number = number;
    }

    private boolean isValidPhoneNumber(String number) {
        return StringUtils.isNotBlank(number) &&
                number.matches("\\d{8,9}");
    }

    private boolean isValidDDD(String ddd) {
        return StringUtils.isNotBlank(ddd) &&
                ddd.matches("\\d{2}");
    }
}
