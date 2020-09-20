package com.kodilla.testing.Shape;


public class Square implements Shape {

    private  final int SquareSide;
    private int SquareField;


    public Square(int SquareSide) {
        this.SquareSide  = SquareSide;
    }


    @Override
    public String getShapeName(){
        return (this.getClass().getSimpleName());
    }

    @Override
    public double getField(){
        SquareField = (SquareSide * SquareSide);
        return SquareField;
    }

    public String toString() {
        return ((this.getClass().getSimpleName()) + " with field of " + SquareField);
    }
}
