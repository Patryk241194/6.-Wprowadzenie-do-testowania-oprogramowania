package com.kodilla.rps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NPCTestSuite {

    private Scanner scanner;

    @Test
    public void testDifficultyLevelTest() {
        //Given
        NPC npc = new NPC(scanner);

        //When
        npc.getDifficultyLevel();

        //Then
        Assertions.assertEquals("N", npc.getDifficultyLevel());
        Assertions.assertEquals(5, npc.getNumberOfRounds());
    }
}
