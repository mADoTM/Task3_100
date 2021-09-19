package ru.vsu.cs.dolzhenkoms.figures;

import java.awt.geom.Point2D;

public class Rectangle {
    public Point2D.Double p1; // Left lower point
    public Point2D.Double p2; // Right upper point

    public Rectangle(Point2D.Double p1, Point2D.Double p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean isPointInsideRectangle(double x, double y) {
        return (x > p1.getX() && x < p2.getX()) && (y > p1.getY() && y < p2.getY());
    }
}
