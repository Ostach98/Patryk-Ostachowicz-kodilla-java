package com.kodilla.testing.Shape;


public class Circle implements Shape {

    private final int r;
    private final double Pi = 3.14;
    private double CircleField;

    public Circle(int r){
        this.r = r;
    }

    @Override
    public String getShapeName(){
        return (this.getClass().getSimpleName());
    }

    @Override
    public double getField(){
        CircleField = Pi * (r *  r);
        return CircleField;
    }

    public String toString(){
        return (this.getClass().getSimpleName()) + " with field of " + CircleField;
    }
}
