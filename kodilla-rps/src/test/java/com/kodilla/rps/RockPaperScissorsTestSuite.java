package com.kodilla.rps;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorsTestSuite {
    RockPaperScissors rps = new RockPaperScissors();

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin\n");
    }

    @AfterEach
    public void after() {
        System.out.println("\nTest Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin\n");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("\nTest Suite: end");
    }

    @Nested
    @DisplayName("Tests for choiceOfUser method")
    class TestChoiceOfUser {
        @Test
        @DisplayName("Test choiceOfUser method when user click '1'")
        void testChoiceOfUserWithValidInput1() {
            // given & when
            String expectedChoice = "Rock";
            String actualChoice = rps.choiceOfUser(1);

            // then
            assertEquals(expectedChoice, actualChoice);
        }

        @Test
        @DisplayName("Test choiceOfUser method when user click '2'")
        void testChoiceOfUserWithValidInput2() {
            // given & when
            String expectedChoice = "Paper";
            String actualChoice = rps.choiceOfUser(2);

            // then
            assertEquals(expectedChoice, actualChoice);
        }

        @Test
        @DisplayName("Test choiceOfUser method when user click '3'")
        void testChoiceOfUserWithValidInput3() {
            // given & when
            String expectedChoice = "Scissors";
            String actualChoice = rps.choiceOfUser(3);

            // then
            assertEquals(expectedChoice, actualChoice);
        }

        @Test
        @DisplayName("Test choiceOfUser method when user click invalid integer input")
        void testChoiceOfUserWithInvalidIntegerInput() {
            // given & when
            // then
            assertThrows(IllegalArgumentException.class, () -> rps.choiceOfUser(4));
        }

        @Test
        @DisplayName("Test choiceOfUser method when user click invalid input type")
        void testChoiceOfUserWithInvalidTypeInput() {
            // given & when
            String invalidInput = "a";
            // then
            assertThrows(NumberFormatException.class, () -> rps.choiceOfUser(Integer.parseInt(invalidInput)));
        }
    }

    @Nested
    @DisplayName("Tests for runGameMechanics method")
    class TestRunGameMechanics {
        @Test
        @DisplayName("Test runGameMechanics method when user and npc pick the same option")
        void testRunGameMechanicsWhenUserAndNpcPickTheSameOption() {
            // given
            User user = new User("User1");
            NPC npc = new NPC("H", 2);

            // when
            rps.setUser(user);
            rps.setNpc(npc);
            rps.setUserChoice("Paper");
            rps.setNpcChoice("Paper");
            rps.runGameMechanics();

            // then
            assertEquals(0, user.getNumberOfRoundsWon());
            assertEquals(0, npc.getNumberOfRoundsWon());
            assertEquals("H", npc.getDifficultyLevel());
            assertEquals(2, npc.getNumberOfRounds());
        }

        @Test
        @DisplayName("Test runGameMechanics method when user wins the round")
        void testRunGameMechanicsWhenUserWinsTheRound() {
            // given
            User user = new User("User1");
            NPC npc = new NPC("N", 3);

            // when
            rps.setUser(user);
            rps.setNpc(npc);
            rps.setUserChoice("Scissors");
            rps.setNpcChoice("Paper");
            rps.runGameMechanics();

            // then
            assertEquals(1, user.getNumberOfRoundsWon());
            assertEquals(0, npc.getNumberOfRoundsWon());
            assertEquals("N", npc.getDifficultyLevel());
            assertEquals(3, npc.getNumberOfRounds());
        }

        @Test
        @DisplayName("Test runGameMechanics method when NPC wins the round")
        void testRunGameMechanicsWhenNPCWinsTheRound() {
            // given
            User user = new User("User1");
            NPC npc = new NPC("N", 4);

            // when
            rps.setUser(user);
            rps.setNpc(npc);
            rps.setUserChoice("Rock");
            rps.setNpcChoice("Paper");
            rps.runGameMechanics();

            // then
            assertEquals(0, user.getNumberOfRoundsWon());
            assertEquals(1, npc.getNumberOfRoundsWon());
            assertEquals("N", npc.getDifficultyLevel());
            assertEquals(4, npc.getNumberOfRounds());
        }
    }

    @Nested
    @DisplayName("Tests for displayStartScreen method")
    class TestDisplayStartScreen {
        @Test
        @DisplayName("Test displayStartScreen method")
        void testDisplayStartScreen() {
            // given
            User user = new User("User1");
            NPC npc = new NPC("H", 2);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            // when
            rps.setNpc(npc);
            rps.setUser(user);

            //then
            String expectedOutput = "\nWelcome User1. You need to win 2 rounds to win the game.\n";
            System.setOut(new PrintStream(outputStream));
            rps.displayStartScreen();
            String actualOutput = outputStream.toString();
            assertEquals(expectedOutput.trim(), actualOutput.trim());
        }
    }

    @Nested
    @DisplayName("Tests for showResult method")
    class TestShowResult {
        @Test
        @DisplayName("Test showResult method when neither player has won")
        void testShowResultWhenNeitherPlayerHasWon() {
            // given
            User user = new User("User1");
            NPC npc = new NPC("N", 4);

            // when
            rps.setUser(user);
            rps.setNpc(npc);
            user.setNumberOfRoundsWon(0);
            npc.setNumberOfRoundsWon(0);
            boolean isGameDone = rps.showResult();
            // then
            assertFalse(isGameDone);
        }

        @Test
        @DisplayName("Test showResult method when the user has won")
        void testShowResultWhenUserHasWon() {
            // given
            User user = new User("User1");
            NPC npc = new NPC("N", 3);

            // when
            rps.setUser(user);
            rps.setNpc(npc);
            user.setNumberOfRoundsWon(3);
            npc.setNumberOfRoundsWon(1);
            boolean isGameDone = rps.showResult();
            // then
            assertTrue(isGameDone);
            assertEquals(user.getNumberOfRoundsWon(), npc.getNumberOfRounds());
        }

        @Test
        @DisplayName("Test showResult method when the NPC has won")
        void testShowResultWhenNPCHasWon() {
            // given
            User user = new User("User1");
            NPC npc = new NPC("H", 4);

            // when
            rps.setUser(user);
            rps.setNpc(npc);
            user.setNumberOfRoundsWon(2);
            npc.setNumberOfRoundsWon(4);
            boolean isGameDone = rps.showResult();
            // then
            assertTrue(isGameDone);
            assertEquals(npc.getNumberOfRoundsWon(), npc.getNumberOfRounds());
        }
    }

    @Nested
    @DisplayName("Tests for isEndOfGame method")
    class TestIsEndOfGame {

        @Test
        @DisplayName("Test isEndOfGame method when match is over and user wants to continue playing")
        void testIsEndOfGameWhenMatchOverAndUserWantsToContinue() {
            // given
            User user = new User("User1");
            NPC npc = new NPC("N", 2);
            String isGameContinued = "n";

            // when
            rps.setUser(user);
            rps.setNpc(npc);
            user.setNumberOfRoundsWon(2);
            npc.setNumberOfRoundsWon(1);
            boolean actualGameOver = rps.isEndOfGame(isGameContinued);

            // then
            assertFalse(actualGameOver);
        }

        @Test
        @DisplayName("Test isEndOfGame method when match is over and user wants to stop playing")
        void testIsEndOfGameWhenMatchOverAndUserWantsToQuit() {
            // given
            User user = new User("User1");
            NPC npc = new NPC("N", 2);
            String isGameContinued = "x";

            // when
            rps.setUser(user);
            rps.setNpc(npc);
            user.setNumberOfRoundsWon(2);
            npc.setNumberOfRoundsWon(1);
            boolean actualGameOver = rps.isEndOfGame(isGameContinued);

            // then
            assertTrue(actualGameOver);
        }

        @Test
        @DisplayName("Test isEndOfGame method if stats reset")
        void testIsEndOfGameIfStatsReset() {
            // given
            User user = new User("User1");
            NPC npc = new NPC("N", 3);
            String isGameContinued = "n";

            // when
            rps.setUser(user);
            rps.setNpc(npc);
            user.setNumberOfRoundsWon(3);
            npc.setNumberOfRoundsWon(1);
            boolean actualGameOver = rps.isEndOfGame(isGameContinued);

            // then
            assertEquals(0, user.getNumberOfRoundsWon());
            assertEquals(0, npc.getNumberOfRoundsWon());
        }
    }
}


