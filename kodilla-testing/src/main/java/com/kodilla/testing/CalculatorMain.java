package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class CalculatorMain {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int result = calculator.addAToB(54, 22);
        System.out.println(result);

        int result1 = calculator.subtractAFromB(23, 12);
        System.out.println(result1);
    }
}


