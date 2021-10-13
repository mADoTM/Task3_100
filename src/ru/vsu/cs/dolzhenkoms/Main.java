package ru.vsu.cs.dolzhenkoms;

import ru.vsu.cs.dolzhenkoms.figures.HorizontalParabola;
import ru.vsu.cs.dolzhenkoms.figures.Line;
import ru.vsu.cs.dolzhenkoms.figures.Rectangle;
import ru.vsu.cs.dolzhenkoms.figures.VerticalParabola;

import java.awt.geom.Point2D;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static Line L1 = new Line(0, -1, 1);
    private static HorizontalParabola HP1 = new HorizontalParabola(-2, -4, -0.25);
    private static VerticalParabola VP1 = new VerticalParabola(4, -5, 0.25);
    private static Rectangle RC1 = new Rectangle(new Point2D.Double(-5.0,-3.0), new Point2D.Double(3.0,4.0));

    private static Picture picture = new Picture(L1, HP1, VP1, RC1);
    private static TestCase tester = new TestCase();

    public static void main(String[] args) {
        if(tester.testCompleted == false) {
            System.out.println("Tests are not completed");
            System.exit(1);
        }

        double x = readNumber("X");
        double y = readNumber("Y");

        SimpleColor color = picture.getColor(x,y);

        printColor(x,y,color);
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
