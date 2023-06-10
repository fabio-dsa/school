package com.school.integration.repository;

import com.school.business.entity.vo.CPF;
import com.school.business.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, CPF> {
}
