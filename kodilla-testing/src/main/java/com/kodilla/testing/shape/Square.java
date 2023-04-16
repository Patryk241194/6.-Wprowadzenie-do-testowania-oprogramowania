package com.kodilla.testing.shape;

public class Square implements Shape {
    protected double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public Double getField() {
        return sideLength * sideLength;
    }
}
