package com.school.domain.student;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private CPF cpf;

    private String name;

    private Email email;

    private List<Phone> phones = new ArrayList<>();

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public void addPhone(String ddd, String number) {
        var phone = Phone.builder()
                .ddd(ddd)
                .number(number)
                .build();
        this.phones.add(phone);
    }
}
