package com.ga.oop;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("Triangle CIRCUMFERENCE: " + triangle.getCircumference() + ", AREA: " + triangle.getArea());

        Circle circle = new Circle(4);
        System.out.println("Circle CIRCUMFERENCE: " + circle.getCircumference() + ", AREA: " + circle.getArea());
    }
}
