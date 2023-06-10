package com.school.presentation.rest;

import com.school.business.usecase.RegisterStudentUseCase;
import com.school.presentation.api.dto.StudentRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {

    private final RegisterStudentUseCase registerStudentUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerStudent(@Valid @RequestBody StudentRequestDTO dto) {
        this.registerStudentUseCase.registerStudent(dto);
    }
}
