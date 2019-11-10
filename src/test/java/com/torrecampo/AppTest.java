package com.torrecampo;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest 
{
    @Test
    public void pointsConvertToSides() {
        Point pt1 = new Point(-6,5);
        Point pt2 = new Point(-2,10);
        Point pt3 = new Point(-3,3);
        Triangle tri = new Triangle(pt1, pt2, pt3, 0, 0, 0);
        double expectedA = 6.4031242374328485;
        double expectedB = 7.0710678118654755;
        double expectedC = 3.605551275463989;
        assertEquals(tri.a, expectedA, 0);
        assertEquals(tri.b, expectedB, 0);
        assertEquals(tri.c, expectedC, 0);
    }

    @Test
    public void triangleIsValid1() {
        Triangle tri = new Triangle(null, null, null, 7, 10, 5);
        assertTrue(tri.isValid());
    }

    @Test
    public void triangleIsValid2() {
        Triangle tri = new Triangle(null, null, null, 7, 5, 10);
        assertTrue(tri.isValid());
    }

    @Test
    public void triangleIsValid3() {
        Triangle tri = new Triangle(null, null, null, 5, 10, 7);
        assertTrue(tri.isValid());
    }

    @Test
    public void triangleIsValid4() {
        Triangle tri = new Triangle(null, null, null, 5, 7, 10);
        assertTrue(tri.isValid());
    }

    @Test
    public void triangleIsValid5() {
        Triangle tri = new Triangle(null, null, null, 10, 5, 7);
        assertTrue(tri.isValid());
    }

    @Test
    public void triangleIsValid6() {
        Triangle tri = new Triangle(null, null, null, 10, 7, 5);
        assertTrue(tri.isValid());
    }

    @Test
    public void rejectInvalidTriangle1() {
        Triangle tri = new Triangle(null, null, null, 1, 10, 12);
        assertFalse(tri.isValid());
    }

    @Test
    public void rejectInvalidTriangle2() {
        Triangle tri = new Triangle(null, null, null, 1, 12, 10);
        assertFalse(tri.isValid());
    }

    @Test
    public void rejectInvalidTriangle3() {
        Triangle tri = new Triangle(null, null, null, 10, 1, 12);
        assertFalse(tri.isValid());
    }

    @Test
    public void rejectInvalidTriangle4() {
        Triangle tri = new Triangle(null, null, null, 10, 12, 1);
        assertFalse(tri.isValid());
    }

    @Test
    public void rejectInvalidTriangle5() {
        Triangle tri = new Triangle(null, null, null, 12, 10, 1);
        assertFalse(tri.isValid());
    }

    @Test
    public void rejectInvalidTriangle6() {
        Triangle tri = new Triangle(null, null, null, 12, 1, 10);
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
    public void nullPoint1() {
        Point pt1 = new Point(0,0);
        Point pt2 = new Point(1,1);
        Point pt3 = null;
        Triangle tri = new Triangle(pt1, pt2, pt3, 0, 0, 0);
        assertFalse(tri.isValid());
    }

    @Test
    public void nullPoint2() {
        Point pt1 = new Point(0,0);
        Point pt2 = null;
        Point pt3 = new Point(1,1);
        Triangle tri = new Triangle(pt1, pt2, pt3, 0, 0, 0);
        assertFalse(tri.isValid());
    }

    @Test
    public void nullPoint3() {
        Point pt1 = null;
        Point pt2 = new Point(1,1);
        Point pt3 = new Point(0,0);
        Triangle tri = new Triangle(pt1, pt2, pt3, 0, 0, 0);
        assertFalse(tri.isValid());
    }

    @Test
    public void checkEquilateral() {
        Triangle tri = new Triangle(null, null, null, 3, 3, 3);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isEquilateral());
        }
    }

    @Test
    public void checkNotEquilateral() {
        Triangle tri = new Triangle(null, null, null, 5, 4, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertFalse(tri.isEquilateral());
        }
    }

    @Test
    public void checkNotEquilateral2() {
        Triangle tri = new Triangle(null, null, null, 3, 3, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertFalse(tri.isEquilateral());
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
    public void checkIsosceles2() {
        Triangle tri = new Triangle(null, null, null, 3, 1, 3);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isIsosceles());
        }
    }

    @Test
    public void checkIsosceles3() {
        Triangle tri = new Triangle(null, null, null, 3, 3, 1);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isIsosceles());
        }
    }

    @Test
    public void checkIsosceles4() {
        Triangle tri = new Triangle(null, null, null, 3, 3, 3);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isIsosceles());
        }
    }

    @Test
    public void checkNotIsosceles2() {
        Triangle tri = new Triangle(null, null, null, 3, 4, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertFalse(tri.isIsosceles());
        }
    }

    @Test
    public void checkNotIsosceles3() {
        Triangle tri = new Triangle(null, null, null, 3, 5, 4);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertFalse(tri.isIsosceles());
        }
    }

    @Test
    public void checkNotIsosceles4() {
        Triangle tri = new Triangle(null, null, null, 4, 5, 3);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertFalse(tri.isIsosceles());
        }
    }

    @Test
    public void checkNotIsosceles5() {
        Triangle tri = new Triangle(null, null, null, 4, 3, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertFalse(tri.isIsosceles());
        }
    }

    @Test
    public void checkNotIsosceles6() {
        Triangle tri = new Triangle(null, null, null, 5, 4, 3);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertFalse(tri.isIsosceles());
        }
    }

    @Test
    public void checkIsosceles5() {
        Triangle tri = new Triangle(null, null, null, 5, 3, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isIsosceles());
        }
    }

    @Test
    public void checkScalene1() {
        Triangle tri = new Triangle(null, null, null, 7, 10, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isScalene());
        }
    }

    @Test
    public void checkScalene2() {
        Triangle tri = new Triangle(null, null, null, 7, 5, 10);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isScalene());
        }
    }

    @Test
    public void checkScalene3() {
        Triangle tri = new Triangle(null, null, null, 5, 10, 7);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isScalene());
        }
    }

    @Test
    public void checkScalene4() {
        Triangle tri = new Triangle(null, null, null, 5, 7, 10);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isScalene());
        }
    }

    @Test
    public void checkScalene5() {
        Triangle tri = new Triangle(null, null, null, 10, 5, 7);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isScalene());
        }
    }

    @Test
    public void checkScalene6() {
        Triangle tri = new Triangle(null, null, null, 10, 7, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isScalene());
        }
    }

    @Test
    public void checkNotScalene1() {
        Triangle tri = new Triangle(null, null, null, 3, 3, 3);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertFalse(tri.isScalene());
        }
    }

    @Test
    public void checkNotScalene2() {
        Triangle tri = new Triangle(null, null, null, 3, 3, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertFalse(tri.isScalene());
        }
    }

    @Test
    public void checkNotScalene3() {
        Triangle tri = new Triangle(null, null, null, 5, 3, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertFalse(tri.isScalene());
        }
    }

    @Test
    public void checkNotScalene4() {
        Triangle tri = new Triangle(null, null, null, 5, 3, 3);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertFalse(tri.isScalene());
        }
    }

    @Test
    public void checkRight1() {
        Triangle tri = new Triangle(null, null, null, 3, 4, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isRight());
        }
    }

    @Test
    public void checkRight2() {
        Triangle tri = new Triangle(null, null, null, 3, 5, 4);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isRight());
        }
    }

    @Test
    public void checkRight3() {
        Triangle tri = new Triangle(null, null, null, 4, 5, 3);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isRight());
        }
    }

    @Test
    public void checkRight4() {
        Triangle tri = new Triangle(null, null, null, 4, 3, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isRight());
        }
    }

    @Test
    public void checkRight5() {
        Triangle tri = new Triangle(null, null, null, 5, 3, 4);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isRight());
        }
    }

    @Test
    public void checkRight6() {
        Triangle tri = new Triangle(null, null, null, 5, 4, 3);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isRight());
        }
    }

    @Test
    public void checkNotRight() {
        Triangle tri = new Triangle(null, null, null, 5, 5, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertFalse(tri.isRight());
        }
    }

    @Test
    public void checkSemiPerimeter() {
        Triangle tri = new Triangle(null, null, null, 3, 4, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            double actual = tri.getSemiPerimeter();
            double expected = 6.0;
            assertEquals(expected, actual, 0);
        }
    }

    @Test
    public void checkArea() {
        Triangle tri = new Triangle(null, null, null, 5, 4, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            tri.getSemiPerimeter();
            double actual = tri.getArea();
            double expected = 9.17;
            assertEquals(expected, actual, 0.01);
        }
    }

    @Test
    public void checkRightScalene() {
        Triangle tri = new Triangle(null, null, null, 3, 4, 5);
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isRight());
            assertTrue(tri.isScalene());
        }
    }

    @Test
    public void checkRightIsosceles() {
        Triangle tri = new Triangle(null, null, null, 1, 1, Math.sqrt(2));
        if(tri.isValid() && !tri.isDegenerate()) {
            assertTrue(tri.isRight());
            assertTrue(tri.isIsosceles());
        }
    }
}
