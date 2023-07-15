package com.kodilla.spring.average;

import java.util.List;

public class WeightedAverageCalculator {

    public static double calculateWeightedAverage(List<Integer> grades, List<Integer> weights) {
        if (grades.size() != weights.size()) {
            throw new IllegalArgumentException("The size of both collections must be the same.");
        }
        if (grades.isEmpty() || weights.isEmpty()) {
            throw new IllegalArgumentException("The size of both collections cannot be equal to 0");
        }

        int sumGrades = 0;
        int sumWeightedGrades = 0;

        for (int i = 0; i < grades.size(); i++) {
            int grade = grades.get(i);
            int weight = weights.get(i);

            if (grade < 1 || grade > 6) {
                throw new IllegalArgumentException("Grades must be in the range of 1-6");
            }
            if (weight < 1 || weight > 10) {
                throw new IllegalArgumentException("Weights must be in the range of 1-10");
            }

            sumGrades += grade;
            sumWeightedGrades += grade * weight;
        }

        return (double) sumWeightedGrades / sumGrades;
    }
}
