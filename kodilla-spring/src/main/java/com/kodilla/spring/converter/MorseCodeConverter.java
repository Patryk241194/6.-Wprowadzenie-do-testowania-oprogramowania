package com.kodilla.spring.converter;

import java.util.HashMap;

public class MorseCodeConverter {

    private static HashMap<String, String> morseCodeMap;

    public MorseCodeConverter() {
        morseCodeMap = new HashMap<>();
        morseCodeMap.put(".-", "A");
        morseCodeMap.put("-...", "B");
        morseCodeMap.put("-.-.", "C");
        morseCodeMap.put("-..", "D");
        morseCodeMap.put(".", "E");
        morseCodeMap.put("..-.", "F");
        morseCodeMap.put("--.", "G");
        morseCodeMap.put("....", "H");
        morseCodeMap.put("..", "I");
        morseCodeMap.put(".---", "J");
        morseCodeMap.put("-.-", "K");
        morseCodeMap.put(".-..", "L");
        morseCodeMap.put("--", "M");
        morseCodeMap.put("-.", "N");
        morseCodeMap.put("---", "O");
        morseCodeMap.put(".--.", "P");
        morseCodeMap.put("--.-", "Q");
        morseCodeMap.put(".-.", "R");
        morseCodeMap.put("...", "S");
        morseCodeMap.put("-", "T");
        morseCodeMap.put("..-", "U");
        morseCodeMap.put("...-", "V");
        morseCodeMap.put(".--", "W");
        morseCodeMap.put("-..-", "X");
        morseCodeMap.put("-.--", "Y");
        morseCodeMap.put("--..", "Z");
    }

    public String translateMorseCode(String morseCode) {
        StringBuilder result = new StringBuilder();

        String[] words = morseCode.split("   ");

        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                if (morseCodeMap.containsKey(letter)) {
                    result.append(morseCodeMap.get(letter));
                } else {
                    result.append(" ");
                }
            }
            result.append(" ");
        }
        return result.toString().trim();

    }
}
