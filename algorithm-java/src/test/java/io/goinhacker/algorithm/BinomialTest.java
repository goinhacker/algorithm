package io.goinhacker.algorithm;

import static io.goinhacker.algorithm.Binomial.binomialByDynamic;
import static io.goinhacker.algorithm.Binomial.binomialByMemozation;
import static io.goinhacker.algorithm.Binomial.binomialByRecursion;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinomialTest {

    @Test
    public void testRecursion() {
        assertEquals(binomialByRecursion(5, 3), 10);
    }

    @Test
    public void testMemozation() {
        assertEquals(binomialByMemozation(5, 3), 10);
    }

    @Test
    public void testDynamicProgramming() {
        assertEquals(binomialByDynamic(5, 3), 10);
    }

}