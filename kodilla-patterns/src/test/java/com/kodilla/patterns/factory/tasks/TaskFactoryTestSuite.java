package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static com.kodilla.patterns.factory.tasks.TaskFactory.*;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShopping() {
        //Given
        Task task1 = TaskFactory.createTask(SHOPPING, "taskName1");
        //When
        task1.executeTask();
        //Then
        assertTrue(task1.isTaskExecuted());
        assertEquals("taskName1", task1.getTaskName());
    }

    @Test
    void testFactoryPainting() {
        //Given
        Task task2 = TaskFactory.createTask(PAINTING, "taskName2");
        //When & Then
        assertFalse(task2.isTaskExecuted());
        assertEquals("taskName2", task2.getTaskName());
    }

    @Test
    void testFactoryDriving() {
        //Given
        Task task3 = TaskFactory.createTask(DRIVING, "taskName3");
        //When
        task3.executeTask();
        //Then
        assertTrue(task3.isTaskExecuted());
        assertEquals("taskName3", task3.getTaskName());
    }

    @Test
    void testFactoryDefault() {
        // Given, When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            Task task4 = TaskFactory.createTask("RACING", "taskName4");
        });
    }
}
