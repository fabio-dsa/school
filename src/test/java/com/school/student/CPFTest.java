package com.school.student;

import com.school.business.entity.vo.CPF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CPFTest {

    @ParameterizedTest(name = "Throw exception for invalid CPF number: {0}")
    @MethodSource("provideInvalidCPFNumbers")
    void shouldThrowExceptionWhenReceivingInvalidCPFNumber(String cpf) {
        // assert
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new CPF(cpf))
        ;
    }

    @Test
    @DisplayName("Should Approve Valid CPF number Format")
    void shouldApproveValidCPFNumberFormat() {
        // arrange
        var cpfNumber = "203.022.192-02";

        // act
        var cpf = new CPF(cpfNumber);

        // assert
        Assertions.assertEquals(cpfNumber, cpf.getNumber());
    }

    private static Stream<Arguments> provideInvalidCPFNumbers() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(""),
                Arguments.of("93293023")
        );
    }
}
