package ru.vsu.cs.dolzhenkoms;

import ru.vsu.cs.dolzhenkoms.figures.*;
import ru.vsu.cs.dolzhenkoms.figures.Rectangle;

import java.awt.geom.Point2D;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final Line L1 = new Line(0, -1, 1);
    public static final HorizontalParabola HP1 = new HorizontalParabola(-2, -4, -0.5);
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

        SimpleColor pointColor = getColor(x,y);

        printColor(x,y,pointColor);
    }

    public static SimpleColor getColor(double x, double y) {



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
