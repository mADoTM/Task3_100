package ru.vsu.cs.dolzhenkoms;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if(TestCase.testCompleted == false) {
            System.out.println("Tests are not completed");
            System.exit(1);
        }


        double x = readNumber("X");
        double y = readNumber("Y");

        SimpleColor color = Picture.getColor(x,y);

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
