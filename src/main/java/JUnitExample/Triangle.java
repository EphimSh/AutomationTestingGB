package JUnitExample;

import java.lang.Math.*;

public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        if ((a == 0 || a < 0) || (b == 0 || b < 0) || (c == 0 || c < 0)) {
            throw new ArithmeticException();
        } else if (a + b < c || a + c < b || b + c < a) {
            throw new ArithmeticException();
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        ;

    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public Double getAreaOfTriangle() {
        double semiPerimeter = (getA() + getB() + getC()) / 2.0;
        return Math.sqrt(semiPerimeter * ((semiPerimeter - getA()) * (semiPerimeter - getB()) * (semiPerimeter - getC())));
    }

}
