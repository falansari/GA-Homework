package com.ga.oop;

public class Triangle extends Shape {
    private final double side1;
    private final double side2;
    private final double side3;

    /**
     * Init triangle object.
     * @param side1
     * @param side2
     * @param side3
     */
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getCircumference() {
        return side1 + side2 + side3;
    }

    @Override
    public double getArea() {
        // Heron's formula:
        // area = 0.25 × √( (a + b + c) × (-a + b + c) × (a - b + c) × (a + b - c) )
        return 0.25 * Math.sqrt((this.getCircumference()) * (-side1 + side2 + side3) * (side1 - side2 + side3) * (side1 + side2 - side3));
    }
}