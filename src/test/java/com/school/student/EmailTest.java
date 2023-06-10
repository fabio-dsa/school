package com.school.student;

import com.school.domain.student.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class EmailTest {

    @ParameterizedTest(name = "Throw exception for invalid  email address: {0}")
    @MethodSource("provideInvalidEmailAddress")
    void shouldThrowExceptionWhenReceivingInvalidEmailAddress(String emailAddress) {
        // assert
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Email(emailAddress))
        ;
    }

    @Test
    @DisplayName("Should Approve Valid Email Format")
    void shouldApproveValidEmailFormat() {
        // arrange
        var emailAddress = "xpto@xpto.com";

        // act
        var email = new Email(emailAddress);

        // assert
        Assertions.assertEquals(emailAddress, email.getAddress());
    }

    private static Stream<Arguments> provideInvalidEmailAddress() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(""),
                Arguments.of("abcdefgha342")
        );
    }
}
