package com.kodilla.testing.shape;

import com.kodilla.testing.Shape.Circle;
import com.kodilla.testing.Shape.ShapeCollector;
import com.kodilla.testing.Shape.Square;
import com.kodilla.testing.Shape.Triangle;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;



public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeALLTests() {
        System.out.println("This is beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void addFigureTest() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle circle = new Circle(10);
        Square square = new Square(6);
        //When
        collector.addFigure(circle);
        collector.addFigure(square);
        //Then
        Assert.assertEquals(2, collector.collectedShapesQuantity());
    }

    @Test
    public void removeFigureTest() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle circle = new Circle(10);
        Square square = new Square(6);
        collector.addFigure(circle);
        collector.addFigure(square);
        //When
        collector.removeFigure(square);
        //Then
        Assert.assertEquals(1, collector.collectedShapesQuantity());
    }

    @Test
    public void getFigureTest() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        //When
        Circle circle = new Circle(10);
        collector.addFigure(circle);
        //Then
        Assert.assertEquals(circle, collector.getFigure(0));

    }
    @Test
    public void showFiguresTest(){
        //given
        ShapeCollector collector = new ShapeCollector();
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(7, 2);
        Square square = new Square(6);
        //When
        collector.addFigure(circle);
        collector.addFigure(triangle);
        collector.addFigure(square);
        //when
        collector.showFigures();
    }
}
