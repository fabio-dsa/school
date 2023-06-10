package com.school.business.usecase;

import com.school.business.entity.Student;
import com.school.integration.repository.StudentRepository;
import com.school.presentation.api.dto.StudentRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterStudentUseCase {

    private final StudentRepository studentRepository;

    public Student registerStudent(StudentRequestDTO dto) {
        return studentRepository.save(dto.toEntity());
    }

}
