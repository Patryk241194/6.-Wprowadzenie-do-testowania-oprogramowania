package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    private final String mentorName;
    private int updateCount;

    public Mentor(String username) {
        this.mentorName = username;
    }

    @Override
    public void update(StudentTask studentTask) {
        System.out.println("New task from " + studentTask.getStudentName() +
                " for mentor " + mentorName + ": " + studentTask.getTasks().peekLast());
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
