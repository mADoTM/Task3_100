package ru.vsu.cs.dolzhenkoms;

import ru.vsu.cs.dolzhenkoms.figures.*;
import ru.vsu.cs.dolzhenkoms.figures.Rectangle;

import java.awt.geom.Point2D;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final Line L1 = new Line(0, -1, 1);
    public static final HorizontalParabola HP1 = new HorizontalParabola(-2, -4, -0.25);
    public static final VerticalParabola VP1 = new VerticalParabola(4, -5, 0.25);
    public static final Rectangle RC1 = new Rectangle(new Point2D.Double(-5.0,-3.0), new Point2D.Double(3.0,4.0));
    public static final Rectangle RC2 = new Rectangle(new Point2D.Double(0,3.0), new Point2D.Double(5.0,30.0));

    public enum SimpleColor {
        BLACK,
        WHITE,
        GRAY,
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        BLUE
    }

    public static void main(String[] args) {
        double x = readNumber("X");
        double y = readNumber("Y");

        SimpleColor color = getColor(x,y);

        printColor(x,y,color);
    }

    public static SimpleColor getColor(double x, double y) {
        if(Math.abs(x) > 10 || Math.abs(y) > 10) {
            System.out.println("[ERROR]Entered wrong data. Color sets in white");
        } else {
            if (L1.isPointAboveLine(x,y)) {
                if(HP1.isPointLeftOfParabola(x,y)) {
                    if(RC1.isPointInsideRectangle(x,y)) {
                        return SimpleColor.GREEN;
                    }
                    return SimpleColor.YELLOW;
                }
                if(RC1.isPointInsideRectangle(x,y)) {
                    if(VP1.isPointInsideOfParabola(x,y)) {
                        if(RC2.isPointInsideRectangle(x,y)) {
                            return SimpleColor.GRAY;
                        }
                        return SimpleColor.ORANGE;
                    } else {
                        return SimpleColor.YELLOW;
                    }
                }
                if(VP1.isPointInsideOfParabola(x,y)) {
                    if(RC2.isPointInsideRectangle(x,y)) {
                        return SimpleColor.WHITE;
                    } else {
                        if(x < 0) {
                            return SimpleColor.YELLOW;
                        }
                        return SimpleColor.BLUE;
                    }
                }
                if(y > -1) {
                    return SimpleColor.WHITE;
                }
                return SimpleColor.ORANGE;
            } else {
                if(VP1.isPointInsideOfParabola(x,y)) {
                    if(RC1.isPointInsideRectangle(x,y)) {
                        return SimpleColor.BLUE;
                    }
                    if(RC2.isPointInsideRectangle(x,y)) {
                        return SimpleColor.GREEN;
                    }
                    return SimpleColor.GRAY;
                } else {
                    if(RC1.isPointInsideRectangle(x,y)) {
                        return SimpleColor.ORANGE;
                    } else if(HP1.isPointLeftOfParabola(x,y)) {
                        return SimpleColor.WHITE;
                    }
                    return SimpleColor.BLUE;
                }
            }
        }

        return SimpleColor.WHITE;
    }

    private static double readNumber(String coordinateName) {
        Scanner scn = new Scanner(System.in);
        double value;

        try {
            System.out.printf("[SYSTEM] Input %s - ", coordinateName);
            value = scn.nextDouble();
        }
        catch (Exception exc) {
            System.out.println("[ERROR] Entered wrong data. Value sets in 0");
            value = 0;
        }

        if(value > 10 || value < - 10) {
            System.out.printf("[Warning] |%s| of coordinate can be only less then 10. Value sets in 0 \n", coordinateName.toLowerCase(Locale.ROOT));
            value = 0;
        }

        return value;
    }

    private static void printColor(double x, double y, SimpleColor color) {
        System.out.printf("The color of Point (%s, %s) - %s", x, y, color);
    }
}
