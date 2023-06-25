package com.kodilla.patterns.builder.bigmac;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BigmacValidator {

    private static final List<String> VALID_BUNS = Arrays.asList("with sesame", "without sesame");
    private static final List<String> VALID_SAUCES = Arrays.asList("standard", "1000 island", "barbecue");
    private static final List<String> VALID_INGREDIENTS = Arrays.asList(
            "lettuce", "onion", "bacon", "pickle", "chili peppers", "mushrooms", "shrimp", "cheese");

    public static void validateBigmac(Bigmac bigmac) throws IllegalArgumentException {
        if (!VALID_BUNS.contains(bigmac.getBun())) {
            throw new IllegalArgumentException("Invalid bun type: " + bigmac.getBun());
        }
        if (!VALID_SAUCES.contains(bigmac.getSauce())) {
            throw new IllegalArgumentException("Invalid sauce type: " + bigmac.getSauce());
        }
        List<String> invalidIngredients = bigmac.getIngredients().stream()
                .filter(ingredient -> !VALID_INGREDIENTS.contains(ingredient))
                .collect(Collectors.toList());
        if (!invalidIngredients.isEmpty()) {
            throw new IllegalArgumentException("Invalid ingredients: " + invalidIngredients);
        }
    }
}
