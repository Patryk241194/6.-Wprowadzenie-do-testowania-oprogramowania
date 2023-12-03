package com.kodilla.spring.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MatrixTransposeTest {

    @Test
    public void testTransposeMatrix() {
        // Given
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // When
        int[][] expectedTransposedMatrix = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };
        int[][] actualTransposedMatrix = MatrixTranspose.transposeMatrix(matrix);

        // Then
        assertArrayEquals(expectedTransposedMatrix, actualTransposedMatrix);
    }
}

