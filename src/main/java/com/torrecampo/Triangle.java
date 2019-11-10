package com.torrecampo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

class Triangle {
    double a, b, c, s;
    private Vector<String> types = new Vector<String>();

    Triangle(Point pt1, Point pt2, Point pt3, double sideA, double sideB, double sideC) {
        if(pt1 != null && pt2 != null && pt3 != null) {
            this.a = Math.sqrt((pt2.getX()-pt1.getX())*(pt2.getX()-pt1.getX()) + (pt2.getY()-pt1.getY())*(pt2.getY()-pt1.getY()));
            this.b = Math.sqrt((pt3.getX()-pt2.getX())*(pt3.getX()-pt2.getX()) + (pt3.getY()-pt2.getY())*(pt3.getY()-pt2.getY()));
            this.c = Math.sqrt((pt3.getX()-pt1.getX())*(pt3.getX()-pt1.getX()) + (pt3.getY()-pt1.getY())*(pt3.getY()-pt1.getY()));
        } else {
            this.a = sideA;
            this.b = sideB;
            this.c = sideC;
        }
    }

    boolean isValid() {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    boolean isDegenerate() {
        ArrayList<Double> sides = new ArrayList<>();
        sides.add(a);
        sides.add(b);
        sides.add(c);
        sides.sort(Comparator.comparingDouble(a -> a));
        return (sides.get(0) + sides.get(1)) <= sides.get(2);

    }

    boolean isEquilateral() {
        if (a == b && b == c) {
            types.addElement("Equilateral");
            return true;
        }
        return false;
    }

    boolean isIsosceles() {
        return (a==b) || (b==c) || (a==c);
    }

    boolean isScalene() {
        if (a != b && b != c && a != c) {
            types.addElement("Scalene");
            return true;
        }
        return false;
    }

    // i.e. 2.00 == 2.000004 (used when input is sqrt())
    private static boolean approximatelyEqual(double desiredValue, double actualValue) {
        double diff = Math.abs(desiredValue - actualValue);
        double tolerance = (float) 0.02 /100 * desiredValue;
        return diff < tolerance;
    }

    boolean isRight() {
        double x = Math.pow(a, 2);
        double y = Math.pow(b, 2);
        double z = Math.pow(c, 2);
        if (approximatelyEqual(z, x+y)) {
            types.addElement("Right");
            return true;
        } else if (approximatelyEqual(x, y+z)) {
            types.addElement("Right");
            return true;
        } else if (approximatelyEqual(y, z+x)) {
            types.addElement("Right");
            return true;
        }
        return false;
    }

    double getSemiPerimeter() {
        s = ((a + b + c) / 2);
        return s;
    }

    double getArea() {
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}
