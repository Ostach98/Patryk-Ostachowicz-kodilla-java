package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class CalculatorMain {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int a = 54;
        int b = 31;

        int result = calculator.addAToB(a, b);
        if(calculator.addAToB(a, b) == (a + b)){
            System.out.println("Test one is working");
            System.out.println(result);

        } else{
            System.out.println("Test one isn't working");
        }
        int result1 = calculator.subtractAFromB(a, b);
        if(calculator.subtractAFromB(a, b) == (a + b)){
            System.out.println("Test two is working");
            System.out.println(result1);
        } else {
            System.out.println("Test two isn't working");
        }
    }
}


