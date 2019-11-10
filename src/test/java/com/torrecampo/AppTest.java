package com.torrecampo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void triangleIsValid() {
        Triangle tri = new Triangle(null, null, null, 7, 10, 5);
        assertTrue(tri.isValid());
    }

    @Test
    public void rejectInvalidTriangle() {
        Triangle tri = new Triangle(null, null, null, 1, 10, 12);
        assertFalse(tri.isValid());
    }

    @Test
    public void rejectDegenerateTriangle() {
        Point pt1 = new Point(0,0);
        Point pt2 = new Point(1,1);
        Point pt3 = new Point(2,2);
        Triangle tri = new Triangle(pt1, pt2, pt3, 0, 0, 0);
        assertTrue(tri.isDegenerate());
    }

    @Test
    public void checkEquilateral() {
        Triangle tri = new Triangle(null, null, null, 3, 3, 3);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isEquilateral());
        }
    }

    @Test
    public void checkIsosceles() {
        Triangle tri = new Triangle(null, null, null, 1, 3, 3);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isIsosceles());
        }
    }

    @Test
    public void checkScalene() {
        Triangle tri = new Triangle(null, null, null, 7, 10, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isScalene());
        }
    }

    @Test
    public void checkRight() {
        Triangle tri = new Triangle(null, null, null, 7, 10, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isRight());
        }
    }
}
