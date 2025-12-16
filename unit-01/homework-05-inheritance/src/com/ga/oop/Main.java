package com.ga.oop;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println(getCircumferenceAndArea(triangle));
        
        Circle circle = new Circle(4);
        System.out.println(getCircumferenceAndArea(circle));

        Rectangle rectangle = new Rectangle(4, 5);
        System.out.println(getCircumferenceAndArea(rectangle));

        Square square = new Square(4);
        System.out.println(getCircumferenceAndArea(square));
    }

    private static String getCircumferenceAndArea(Shape shape){
        return (shape.getClass().getSimpleName() + " CIRCUMFERENCE: " + shape.getCircumference() + ", AREA: " + shape.getArea());
    }
}
