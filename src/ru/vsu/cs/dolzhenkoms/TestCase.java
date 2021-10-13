package ru.vsu.cs.dolzhenkoms;

import ru.vsu.cs.dolzhenkoms.figures.HorizontalParabola;
import ru.vsu.cs.dolzhenkoms.figures.Line;
import ru.vsu.cs.dolzhenkoms.figures.Rectangle;
import ru.vsu.cs.dolzhenkoms.figures.VerticalParabola;

import java.awt.geom.Point2D;

public class TestCase {

    public boolean checkGetColor(Picture picture) {
        if(picture.getColor(0,0) != SimpleColor.ORANGE) {
            System.out.println("0,0 test not completed");
            return false;
        }
        if(picture.getColor(1,3.5) != SimpleColor.GRAY) {
            System.out.println("1,3.5 test not completed");
            return false;
        }
        if(picture.getColor(3.1,2.9) != SimpleColor.BLUE) {
            System.out.println("3.1,2.9 test not completed");
            return false;
        }
        if(picture.getColor(4.5,3.3) != SimpleColor.GREEN) {
            System.out.println("4.5,3.3 test not completed");
            return false;
        }
        if(picture.getColor(4,0) != SimpleColor.GRAY) {
            System.out.println("4,0 test not completed");
            return false;
        }
        if(picture.getColor(6,10) != SimpleColor.BLUE) {
            System.out.println("6,10 test not completed");
            return false;
        }
        if(picture.getColor(-2,0) != SimpleColor.YELLOW) {
            System.out.println("-2,0 test not completed");
            return false;
        }
        if(picture.getColor(-1,5) != SimpleColor.YELLOW) {
            System.out.println("-1,5 test not completed");
            return false;
        }
        if(picture.getColor(0,-2) != SimpleColor.ORANGE) {
            System.out.println("0,-2 test not completed");
            return false;
        }
        if(picture.getColor(-4,-2) != SimpleColor.GREEN) {
            System.out.println("-4,-2 test not completed");
            return false;
        }
        if(picture.getColor(-6,-1) != SimpleColor.YELLOW) {
            System.out.println("-6,-1 test not completed");
            return false;
        }
        if(picture.getColor(-4,0) != SimpleColor.YELLOW) {
            System.out.println("-4,0 test not completed");
            return false;
        }
        if(picture.getColor(-6,2) != SimpleColor.WHITE) {
            System.out.println("-6,2 test not completed");
            return false;
        }
        if(picture.getColor(-4,-6) != SimpleColor.WHITE) {
            System.out.println("-4,-6 test not completed");
            return false;
        }
        if(picture.getColor(-10,-10) != SimpleColor.ORANGE) {
            System.out.println("-10,-10 test not completed");
            return false;
        }

        return true;
    }
}
