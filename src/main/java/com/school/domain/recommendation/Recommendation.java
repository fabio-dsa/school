package com.school.domain.recommendation;

import com.school.domain.student.Student;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Recommendation {

    private Student referrer;

    private Student recommended;

    private LocalDate recommendationDate;

    public Recommendation(Student referrer, Student recommended) {
        this.referrer = referrer;
        this.recommended = recommended;
        this.recommendationDate = LocalDate.now();
    }
}
