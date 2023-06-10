package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        String concatenatedTitles = movieStore.getMovies().values().stream()
                .flatMap(List::stream)
                .collect(Collectors.joining(" ! "));

        System.out.println(concatenatedTitles);

        // Factorial extra task
        System.out.println(Factorial.countFactorial(5));
    }
}

