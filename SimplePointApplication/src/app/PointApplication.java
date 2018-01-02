package app;

import data.Point;
import logic.PointController;

public class PointApplication {
    public static final int EXIT = 0;
    private static final int ADD_X = 1;
    private static final int ADD_Y = 2;
    private static final int MINUS_X = 3;
    private static final int MINUS_Y = 4;

    public static void main(String[] args) {
        int pointX = 4;
        int pointY = 8;
        Point point = new Point(pointX, pointY);
        PointController pc = new PointController();
        int option = 3;

        System.out.println(point);
        switch (option) {
            case ADD_X:
                pc.addX(point);
                System.out.println(point);
                break;
            case ADD_Y:
                pc.addY(point);
                System.out.println(point);
                break;
            case MINUS_X:
                pc.minusY(point);
                System.out.println(point);
                break;
            case MINUS_Y:
                pc.minusX(point);
                System.out.println(point);
                break;
            default:
                System.out.println(point);
        }
    }
}
