package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ShapeCollector {

    private List<Shape> shapeList;

    public ShapeCollector() {
        shapeList = new ArrayList<>();
    }

    public int size() {
        return shapeList.size();
    }

    public void addFigure(Shape shape) {
        shapeList.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (shapeList.contains(shape)) {
            shapeList.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
        Shape shape = null;
        if (n >= 0 && n < shapeList.size()) {
            shape = shapeList.get(n);
        }
        return shape;
    }

    public String showFigures() {
        StringJoiner joiner = new StringJoiner(", ");
        for (Shape shape : shapeList) {
            joiner.add(shape.getShapeName());
        }
        return joiner.toString();
    }
}
