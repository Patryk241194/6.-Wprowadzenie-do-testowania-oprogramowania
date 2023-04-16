package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

public class ShapeCollectorTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end\n");
    }


    @Nested
    @DisplayName("Test for circles")
    class TestCircles {
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollection = new ShapeCollector();
            Shape shape = new Circle(20);

            //When
            shapeCollection.addFigure(shape);

            //Then
            Assertions.assertEquals(1, shapeCollection.size());
        }

        @Test
        void testRemoveFigureNotExisting() {
            //Given
            ShapeCollector shapeCollection = new ShapeCollector();
            Shape shape = new Circle(20);

            //When
            boolean result = shapeCollection.removeFigure(shape);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollection = new ShapeCollector();
            Shape shape = new Circle(20);
            shapeCollection.addFigure(shape);

            //When
            boolean result = shapeCollection.removeFigure(shape);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollection.size());

        }

        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollection = new ShapeCollector();
            Shape shape = new Circle(20);
            shapeCollection.addFigure(shape);

            //When
            Shape result = shapeCollection.getFigure(0);

            //Then
            Assertions.assertEquals(shape, result);

        }

    }

    @Nested
    @DisplayName("Test for squares")
    class TestSquares {
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollection = new ShapeCollector();
            Shape shape = new Square(10);

            //When
            shapeCollection.addFigure(shape);

            //Then
            Assertions.assertEquals(1, shapeCollection.size());
        }

        @Test
        void testRemoveFigureNotExisting() {
            //Given
            ShapeCollector shapeCollection = new ShapeCollector();
            Shape shape = new Square(10);

            //When
            boolean result = shapeCollection.removeFigure(shape);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollection = new ShapeCollector();
            Shape shape = new Square(10);
            shapeCollection.addFigure(shape);

            //When
            boolean result = shapeCollection.removeFigure(shape);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollection.size());

        }

        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollection = new ShapeCollector();
            Shape shape = new Square(10);
            shapeCollection.addFigure(shape);

            //When
            Shape result = shapeCollection.getFigure(0);

            //Then
            Assertions.assertEquals(shape, result);

        }

    }

    @Nested
    @DisplayName("Test for triangles")
    class TestTriangles {
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollection = new ShapeCollector();
            Shape shape = new Triangle(15, 5);

            //When
            shapeCollection.addFigure(shape);

            //Then
            Assertions.assertEquals(1, shapeCollection.size());
        }

        @Test
        void testRemoveFigureNotExisting() {
            //Given
            ShapeCollector shapeCollection = new ShapeCollector();
            Shape shape = new Triangle(15, 5);

            //When
            boolean result = shapeCollection.removeFigure(shape);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollection = new ShapeCollector();
            Shape shape = new Triangle(15, 5);
            shapeCollection.addFigure(shape);

            //When
            boolean result = shapeCollection.removeFigure(shape);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollection.size());

        }

        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollection = new ShapeCollector();
            Shape shape = new Triangle(15, 5);
            shapeCollection.addFigure(shape);

            //When
            Shape result = shapeCollection.getFigure(0);

            //Then
            Assertions.assertEquals(shape, result);

        }

    }

    @Nested
    @DisplayName("Test for all figures")
    class TestAllFigures {

        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollection = new ShapeCollector();
            Shape shape1 = new Triangle(15, 5);
            Shape shape2 = new Square(10);
            Shape shape3 = new Circle(20);
            shapeCollection.addFigure(shape1);
            shapeCollection.addFigure(shape2);
            shapeCollection.addFigure(shape3);

            //When
            String result = shapeCollection.showFigures();

            String expectedResult = "Triangle, Square, Circle";

            //Then
            Assertions.assertEquals(expectedResult, result);

        }

    }
}
