package com.school.business.entity;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
