package com.kodilla.patterns2.observer.homework;


import java.util.*;

public class StudentTask implements Observable {

    private final String studentName;
    private final List<Observer> observers;
    private final Deque<String> tasks;

    public StudentTask(String studentName) {
        this.studentName = studentName;
        observers = new ArrayList<>();
        tasks = new ArrayDeque<>();
    }

    public void addTask(String task) {
        tasks.offer(task);
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public String getStudentName() {
        return studentName;
    }

    public Deque<String> getTasks() {
        return tasks;
    }
}
