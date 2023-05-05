package com.kodilla.exception.test;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    public void testProbablyIWillThrowException() {
        // given
        SecondChallenge challenge = new SecondChallenge();
        // when & then
        assertAll(
                () -> assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(1, 1.5)),
                () -> assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(2, 0)),
                () -> assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(0, 2)),
                () -> assertDoesNotThrow(() -> challenge.probablyIWillThrowException(1, 0))
        );
    }

}
