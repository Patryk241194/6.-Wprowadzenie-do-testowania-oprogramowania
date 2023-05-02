package com.kodilla.stream.mirror;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Thong {

    public static String generateMirrorThong(String word) {
        String reversed = Stream.iterate(word.length() - 1, i -> i >= 0, i -> i-1)
                .map(integer -> word.charAt(integer))
                .map(character -> String.valueOf(character))
                .collect(Collectors.joining());

        return reversed;
    }

    public static void main(String[] args) {

        System.out.println(Thong.generateMirrorThong("Adam"));
        System.out.println(Thong.generateMirrorThong("Ewa"));
        System.out.println(Thong.generateMirrorThong("Kajak"));

    }
}
