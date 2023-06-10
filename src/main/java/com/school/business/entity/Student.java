package com.school.business.entity;

import com.school.business.entity.vo.CPF;
import com.school.business.entity.vo.Email;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student {

    @EmbeddedId
    private CPF cpf;

    @Column(name = "name")
    private String name;

    @Embedded
    private Email email;

    @Transient
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
