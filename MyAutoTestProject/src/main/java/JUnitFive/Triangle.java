package JUnitFive;

public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public double areaOfATriangle() {
        double semiperimeter = (getA() + getB() + getC()) / 2.0;
        return Math.sqrt(
                (semiperimeter * ((semiperimeter - getA()) * (semiperimeter - getB()) * (semiperimeter - getC())))
        );
    }
}
