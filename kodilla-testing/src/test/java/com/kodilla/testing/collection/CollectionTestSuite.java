package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end\n");
    }

    @DisplayName("Test to see if the class behaves correctly " +
            "when the list is empty by checking its size")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> testedList = new ArrayList<>();

        //When
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> result = exterminator.exterminate(testedList);

        //Then
        Assertions.assertEquals(0, result.size());
    }

    @DisplayName("Test to see if the class behaves correctly " +
            "when the list contains even and odd numbers.")
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        List<Integer> testedList = new ArrayList<>();
        testedList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        //When
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> result = exterminator.exterminate(testedList);

        List<Integer> expectedResult = Arrays.asList(2, 4, 6, 8, 10);

        //Then
        Assertions.assertEquals(expectedResult, result);
    }

}