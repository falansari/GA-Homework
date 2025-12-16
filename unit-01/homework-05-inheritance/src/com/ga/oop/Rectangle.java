package com.ga.oop;

public class Rectangle extends Shape {
    private final double length;
    private final double width;

    /**
     * Initialize rectangle shape.
     * @param length
     * @param width
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getCircumference() {
        // perimeter = 2L + 2W
        return (2 * length) + (2 * width);
    }

    @Override
    public double getArea() {
        // area = LW
        return length * width;
    }
}
