package com.school.domain.student;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class Email {

    private String address;

    public Email(String address) {
        if (StringUtils.isBlank(address) ||
                !address.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.address = address;
    }
}
