package com.ga.oop;

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getCircumference() {
        // C = 2 π r
        return (2 * Math.PI * radius);
    }

    @Override
    public double getArea() {
        // A = π * r2
        return (Math.PI * Math.pow(radius, 2));
    }
}