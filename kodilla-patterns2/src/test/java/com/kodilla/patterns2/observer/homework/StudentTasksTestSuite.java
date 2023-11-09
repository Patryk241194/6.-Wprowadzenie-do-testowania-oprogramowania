package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTasksTestSuite {

    @Test
    void testTaskQueue() {
        //Given
        StudentTask student1 = new StudentTask("Jan");
        StudentTask student2 = new StudentTask("Patryk");
        StudentTask student3 = new StudentTask("Artur");
        Mentor mentor1 = new Mentor("Mateusz");
        Mentor mentor2 = new Mentor("Marcin");
        student1.registerObserver(mentor1);
        student2.registerObserver(mentor1);
        student3.registerObserver(mentor2);

        //When
        student1.addTask("Kodilla Task Submodule 22.1");
        student2.addTask("Kodilla Task Submodule 23.4");
        student2.addTask("Kodilla Task Submodule 19.1");
        student2.addTask("Kodilla Task Submodule 6.5");
        student3.addTask("Kodilla Task Submodule 13.2");
        student3.addTask("Kodilla Task Submodule 16.3");

        //Then
        assertEquals(4, mentor1.getUpdateCount());
        assertEquals(2, mentor2.getUpdateCount());
    }


}