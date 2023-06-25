package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public static Task createTask(String taskType, String taskName) {
        return switch (taskType) {
            case SHOPPING -> new ShoppingTask(taskName, "Groceries", 10.0);
            case PAINTING -> new PaintingTask(taskName, "Red", "Wall");
            case DRIVING -> new DrivingTask(taskName, "Airport", "Taxi");
            default -> throw new IllegalArgumentException("Unknown task type: " + taskType);
        };
    }
}
