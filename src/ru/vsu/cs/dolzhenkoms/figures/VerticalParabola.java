package ru.vsu.cs.dolzhenkoms.figures;

public class VerticalParabola {
    public double x0;
    public double y0;
    public double a;

    public VerticalParabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointInsideOfParabola(double x, double y) {
        return y > a * Math.pow(x - x0, 2) + y0;
    }
}
