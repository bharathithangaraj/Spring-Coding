package com.testAnnotations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.annotations.MyMath;


class MyMathTest {

	MyMath myMath = new MyMath();

    // MyMath.sum

    // 1,2,3 => 6

    @Test

    public void sum_with3numbers() {

        System.out.println("Test1");

        assertEquals(6, myMath.sum(new int[] {

            1,

            2,

            3

        }));

    }

    @Test

    public void sum_with1number() {

        System.out.println("Test2");

        assertEquals(3, myMath.sum(new int[] {

            3

        }));

    }


}