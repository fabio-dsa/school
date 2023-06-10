package com.school.student;

import com.school.domain.student.Phone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PhoneTest {

    @ParameterizedTest(name = "Throw exception for invalid Phone number - [DDD]: {0}, [Number]: {1}")
    @MethodSource("provideInvalidPhoneNumbers")
    void shouldThrowExceptionWhenReceivingInvalidPhoneNumber(String ddd, String number) {
        // assert
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Phone(ddd, number))
        ;
    }

    @ParameterizedTest(name = "Should approve valid phone number format - [DDD]: {0}, [Number]: {1}")
    @MethodSource("provideValidPhoneNumbers")
    void shouldApproveValidPhoneNumberFormat(String ddd, String number) {
        // act
        var phone = new Phone(ddd, number);

        // assert
        Assertions.assertEquals(ddd, phone.getDdd());
        Assertions.assertEquals(number, phone.getNumber());
    }

    private static Stream<Arguments> provideInvalidPhoneNumbers() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, "000111222"),
                Arguments.of("", "000111222"),
                Arguments.of("dd", "000111222"),
                Arguments.of("01", null),
                Arguments.of("01", ""),
                Arguments.of("01", "abcdefghj"),
                Arguments.of("01", "0190190199"),
                Arguments.of("01", "0190190")
        );
    }

    private static Stream<Arguments> provideValidPhoneNumbers() {
        return Stream.of(
                Arguments.of("95", "991829191"),
                Arguments.of("95", "36235294")
        );
    }
}
