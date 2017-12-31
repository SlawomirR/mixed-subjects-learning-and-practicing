package app;

import data.Point;
import logic.PointController;

public class PointApplication {
    public static void main(String[] args) {
        int pointX = 4;
        int pointY = 8;
        Point point = new Point(pointX, pointY);
        PointController pc = new PointController();

        System.out.println(point);
        pc.addX(point);
        System.out.println(point);
        pc.addY(point);
        System.out.println(point);
        pc.minusY(point);
        System.out.println(point);
        pc.minusX(point);
        System.out.println(point);
    }
}
