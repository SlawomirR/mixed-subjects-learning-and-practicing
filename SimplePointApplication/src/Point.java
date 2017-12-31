public class Point {
    private int partX;
    private int partY;

    protected int getPartX() {
        return partX;
    }
    protected int getPartY() {
        return partY;
    }

    protected void setPartX(int partX) {
        this.partX = partX;
    }
    protected void setPartY(int partY) {
        this.partY = partY;
    }

    Point() {}
    Point(int partX, int partY) {
        this.partX = partX;
        this.partY = partY;

    }

    @Override
    public String toString() {
        return "Point(" + partX + ", " + partY + ')';
    }
}
