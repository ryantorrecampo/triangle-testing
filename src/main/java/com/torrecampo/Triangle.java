package com.torrecampo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

class Triangle {
    private double a, b, c, s;
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
        sides.add(this.a);
        sides.add(this.b);
        sides.add(this.c);
        sides.sort(Comparator.comparingDouble(a -> a));
        return (sides.get(0) + sides.get(1)) <= sides.get(2);

    }

    boolean isEquilateral() {
        if (a == b && b == c) {
            types.addElement("Equilateral");
            return true;
        } else {
            return false;
        }
    }

    boolean isIsosceles() {
        if (a == b) {
            if (a != c || b != c) {
                types.addElement("Isosceles");
                return true;
            }
        }
        else if (a == c) {
            if (a != b || c != b) {
                types.addElement("Isosceles");
                return true;
            }
        }
        else if (b == c) {
            if (b != a || c != a) {
                types.addElement("Isosceles");
                return true;
            }
        }
        return false;
    }

    boolean isScalene() {
        if (a != b && b != c && a != c) {
            types.addElement("Scalene");
            return true;
        } else {
            return false;
        }
    }

    boolean isRight() {
        double x = Math.pow(a, 2);
        double y = Math.pow(b, 2);
        double z = Math.pow(c, 2);
        if (x + y == z) {
            types.addElement("Right");
            return true;
        } else if (y + z == x) {
            types.addElement("Right");
            return true;
        } else if (z + x == y) {
            types.addElement("Right");
            return true;
        } else {
            return false;
        }
    }

    private void printTypes() {
        for (String type : types) {
            System.out.println(type);
        }
    }

    private void getSemiPerimeter() {
        this.s = ((a + b + c) / 2);
    }

    private double getArea() {
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}
