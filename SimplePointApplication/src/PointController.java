public class PointController {
    void addX(Point point) {
        point.setPartX(point.getPartX() + 1);
    }
    void minusX(Point point) {
        point.setPartX(point.getPartX() - 1);
    }
    void addY(Point point) {
        point.setPartY(point.getPartY() + 1);
    }
    void minusY(Point point) {
        point.setPartY(point.getPartY() - 1);
    }
}
