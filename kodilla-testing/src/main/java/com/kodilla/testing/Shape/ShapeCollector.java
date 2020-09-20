package com.kodilla.testing.Shape;

import java.util.ArrayList;

interface Shape{
    String getShapeName();
    double  getField();
}

public class ShapeCollector {

    private final ArrayList<Shape> shapesList = new ArrayList<>();

    public void addFigure(Shape shape){
        shapesList.add(shape);
    }

    public void removeFigure(Shape shape){
        shapesList.remove(shape);
    }

    public Shape getFigure(int n){

        if (n > shapesList.size()){
            return null;
        } else if (n < 0){
            return null;
        } else {
            return shapesList.get(n);}
    }

    public ArrayList<Shape> showFigures(){
        return shapesList;
    }

    public int collectedShapesQuantity() {
        return shapesList.size();
    }

}
