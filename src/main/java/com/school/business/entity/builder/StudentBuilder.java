package com.school.business.entity.builder;

import com.school.business.entity.Student;
import com.school.business.entity.vo.CPF;
import com.school.business.entity.vo.Email;

public class StudentBuilder {

    private Student student;

    public StudentBuilder withNameCPFEmail(String name, String cpf, String emailAddress) {
        this.student = new Student(new CPF(cpf), name, new Email(emailAddress));
        return this;
    }

    public StudentBuilder withPhone(String ddd, String phoneNumber) {
        this.student.addPhone(ddd, phoneNumber);
        return this;
    }

    public Student build() {
        return this.student;
    }
}
