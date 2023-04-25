package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {

        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("\nCalculating expressions with lambdas:");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("\nCalculating expressions with method references:");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("\nSubmodule 7.1. text beautifier:");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("kodilla",(text -> text.toUpperCase()));
        poemBeautifier.beautify("kodilla",(text -> "ABC " + text + " ABC"));
        poemBeautifier.beautify("kodilla",(text -> text.substring(0, 1).toUpperCase() + text.substring(1)));
        poemBeautifier.beautify("kodilla",(text -> text.replaceAll("kod", "godz")));

    }

}
