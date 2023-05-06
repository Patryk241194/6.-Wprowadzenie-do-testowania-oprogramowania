package com.kodilla.rps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

public class GameValidatorTestSuite {

    private final GameValidator validator = new GameValidator();

    @Nested
    @DisplayName("Tests for checkDifficultyLevel method")
    class CheckDifficultyLevelTests {

        @Test
        @DisplayName("Test checkDifficultyLevel method with valid input (N)")
        void testCheckDifficultyLevelValidInputN() throws Exception {
            // given
            String difficulty = "N";

            // when
            String actualDifficultyLevel = validator.checkDifficultyLevel(difficulty);

            // then
            assertEquals("N", actualDifficultyLevel);
        }

        @Test
        @DisplayName("Test checkDifficultyLevel method with valid input (H)")
        void testCheckDifficultyLevelValidInputH() throws Exception {
            // given
            String difficulty = "H";

            // when
            String actualDifficultyLevel = validator.checkDifficultyLevel(difficulty);

            // then
            assertEquals("H", actualDifficultyLevel);
        }

        @Test
        @DisplayName("Test checkDifficultyLevel method with invalid input")
        void testCheckDifficultyLevelInvalidInput() {
            // given
            String difficulty = "E";

            // when & then
            assertThrows(RuntimeException.class, () -> validator.checkDifficultyLevel(difficulty));
        }

    }

    @Nested
    @DisplayName("Tests for checkTheNumberOfRounds method")
    class CheckTheNumberOfRoundsTests {

        @Test
        @DisplayName("Test checkTheNumberOfRounds method with valid input")
        void testCheckTheNumberOfRoundsValidInput() {
            // given
            int amountOfRounds = 3;

            // when
            int actualRoundsToWin = validator.checkTheNumberOfRounds(amountOfRounds);

            // then
            assertEquals(3, actualRoundsToWin);
        }

        @Test
        @DisplayName("Test checkTheNumberOfRounds method with invalid input")
        void testCheckTheNumberOfRoundsInvalidInput() {
            // given
            int amountOfRounds = -2;

            // when & then
            assertThrows(InputMismatchException.class, () -> validator.checkTheNumberOfRounds(amountOfRounds));
        }

        @Test
        @DisplayName("Test checkTheNumberOfRounds method with invalid input type")
        void testCheckTheNumberOfRoundsInvalidTypeInput() {
            // given
            String amountOfRounds = "a";

            // when & then
            assertThrows(NumberFormatException.class, () -> validator.checkTheNumberOfRounds(Integer.parseInt(amountOfRounds)));
        }
    }

    @Nested
    @DisplayName("Tests for checkUserChoice method")
    class CheckUserChoiceTests {

        @Test
        @DisplayName("Test checkUserChoice method with valid input (1)")
        void testCheckUserChoiceValidInput1() {
            // given
            int userInput = 1;

            // when
            String actualChoice = validator.checkUserChoice(userInput);

            // then
            assertEquals("Rock", actualChoice);
        }

        @Test
        @DisplayName("Test checkUserChoice method with valid input (2)")
        void testCheckUserChoiceValidInput2() {
            // given
            int userInput = 2;

            // when
            String actualChoice = validator.checkUserChoice(userInput);

            // then
            assertEquals("Paper", actualChoice);
        }

        @Test
        @DisplayName("Test checkUserChoice method with valid input (3)")
        void testCheckUserChoiceValidInput3() {
            // given
            int userInput = 3;

            // when
            String actualChoice = validator.checkUserChoice(userInput);

            // then
            assertEquals("Scissors", actualChoice);
        }

        @Test
        @DisplayName("Test checkUserChoice method with invalid input")
        void testCheckUserChoiceWithInvalidInput() {
            // given
            int userInput = 4;

            // when & then
            assertThrows(IllegalArgumentException.class, () -> validator.checkUserChoice(userInput));
        }

        @Test
        @DisplayName("Test checkUserChoice method with invalid input type")
        void testCheckUserChoiceWithInvalidTypeInput() {
            // given
            String userInput = "a";

            // when & then
            assertThrows(IllegalArgumentException.class, () -> validator.checkUserChoice(Integer.parseInt(userInput)));
        }
    }

    @Nested
    @DisplayName("Tests for checkWannaPlayAgain method")
    class checkWannaPlayAgainTests {

        @Test
        @DisplayName("Test checkWannaPlayAgain method when input is 'n'")
        void testCheckWannaPlayAgainWhenInputIsN() {
            // given
            String isGameContinued = "n";

            // when
            String actualWannaPlayAgain = validator.checkWannaPlayAgain(isGameContinued);

            // then
            assertEquals("n", actualWannaPlayAgain);
        }

        @Test
        @DisplayName("Test checkWannaPlayAgain method when input is 'x'")
        void testCheckWannaPlayAgainWhenInputIsX() {
            // given
            String isGameContinued = "x";

            // when
            String actualWannaPlayAgain = validator.checkWannaPlayAgain(isGameContinued);

            // then
            assertEquals("x", actualWannaPlayAgain);
        }

        @Test
        @DisplayName("Test checkWannaPlayAgain method when input is invalid")
        void testCheckWannaPlayAgainWhenInputIsInvalid() {
            // given
            String isGameContinued = "invalidInput";

            // when & then
            assertThrows(IllegalArgumentException.class, () -> validator.checkWannaPlayAgain(isGameContinued));
        }

        @Test
        @DisplayName("Test checkWannaPlayAgain method when input is invalid type")
        void testCheckWannaPlayAgainWhenInputIsInvalidType() {
            // given
            int isGameContinued = 3;

            // when & then
            assertThrows(IllegalArgumentException.class, () -> validator.checkWannaPlayAgain(Integer.toString(isGameContinued)));
        }
    }
}
