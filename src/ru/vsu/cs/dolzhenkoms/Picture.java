package ru.vsu.cs.dolzhenkoms;

import ru.vsu.cs.dolzhenkoms.figures.*;

import java.awt.geom.Point2D;

public class Picture {
    private static final Line L1 = new Line(0, -1, 1);
    private static final HorizontalParabola HP1 = new HorizontalParabola(-2, -4, -0.25);
    private static final VerticalParabola VP1 = new VerticalParabola(4, -5, 0.25);
    private static final Rectangle RC1 = new Rectangle(new Point2D.Double(-5.0,-3.0), new Point2D.Double(3.0,4.0));

    public static SimpleColor getColor(double x, double y) {
        if(Math.abs(x) > 10 || Math.abs(y) > 10) {
            System.out.println("[ERROR]Entered wrong data. Color sets in white");
        } else {
            if (L1.isPointAboveLine(x,y)) {
                return getColorFromUpsideZone(x,y);

            } else {
                return getColorFromDownsideZone(x,y);
            }
        }

        return SimpleColor.WHITE;
    }

    private static SimpleColor getColorFromUpsideZone(double x, double y) {
        if(HP1.isPointLeftOfParabola(x,y)) {
            if(RC1.isPointInsideRectangle(x,y)) {
                return SimpleColor.GREEN;
            }
            return SimpleColor.YELLOW;
        }
        if(RC1.isPointInsideRectangle(x,y)) {
            if(VP1.isPointInsideOfParabola(x,y)) {
                if(x > 0 && y > 3) {
                    return SimpleColor.GRAY;
                }
                return SimpleColor.ORANGE;
            } else {
                return SimpleColor.YELLOW;
            }
        }
        if(VP1.isPointInsideOfParabola(x,y)) {
            if(x > 5) {
                return SimpleColor.BLUE;
            }
            if(x < 0) {
                return SimpleColor.YELLOW;
            }
            if(x > 3 && x < 4 && y > 2 && y < 3) {
                return SimpleColor.BLUE;
            }
            return SimpleColor.WHITE;
        }
        if(y > -1) {
            return SimpleColor.WHITE;
        }
        return SimpleColor.ORANGE;
    }

    private static SimpleColor getColorFromDownsideZone(double x, double y) {
        if(VP1.isPointInsideOfParabola(x,y)) {
            if(RC1.isPointInsideRectangle(x,y)) {
                return SimpleColor.BLUE;
            }
            if(x > 4 && x < 5 && y > 3 && y < 4) {
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
