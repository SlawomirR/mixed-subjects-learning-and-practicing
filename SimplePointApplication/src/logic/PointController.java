package logic;

import data.Point;

public class PointController {
    public void addX(Point point) {
        point.setPartX(point.getPartX() + 1);
    }
    public void minusX(Point point) {
        point.setPartX(point.getPartX() - 1);
    }
    public void addY(Point point) {
        point.setPartY(point.getPartY() + 1);
    }
    public void minusY(Point point) {
        point.setPartY(point.getPartY() - 1);
    }
}
