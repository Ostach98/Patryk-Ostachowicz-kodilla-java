package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        //given
        int [] numbers = {6, 4, 3, 2, 5, 2, 3, 3};
        //when
        double result = ArrayOperations.getAverage(numbers);
        //then
        assertEquals(3.5, result);

    }
}
