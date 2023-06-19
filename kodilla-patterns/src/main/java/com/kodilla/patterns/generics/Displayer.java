package com.kodilla.patterns.generics;

public class Displayer<V> {

    public void display1(V value) {
        System.out.println(value);
    }

    public <T> void display2(T value) {
        System.out.println(value);
    }


    public static void main(String[] args) {
        Displayer<Integer> displayer1 = new Displayer<>();
        Displayer<String> displayer2 = new Displayer<>();
        int n = 10;
        String s = "test message";

        displayer1.display1(n);
        displayer2.display1(s);

        Displayer<Object> displayer = new Displayer<>();
        displayer.display2(n);
        displayer.display2(s);
    }
}
