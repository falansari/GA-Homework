package com.ga.oop;

public class Square extends Rectangle {
    private final double side = 0;

    /**
     * Initialize square shape.
     * @param side
     */
    public Square(double side) {
        super(side, side);
    }
}
