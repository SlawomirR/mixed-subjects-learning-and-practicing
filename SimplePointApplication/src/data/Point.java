package data;

public class Point {
    private int partX;
    private int partY;

    public int getPartX() {
        return partX;
    }
    public int getPartY() {
        return partY;
    }

    public void setPartX(int partX) {
        this.partX = partX;
    }
    public void setPartY(int partY) {
        this.partY = partY;
    }

    public Point(int partX, int partY) {
        this.partX = partX;
        this.partY = partY;

    }

    @Override
    public String toString() {
        return "Point(" + partX + ", " + partY + ')';
    }
}
