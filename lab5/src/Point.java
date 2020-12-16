public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @InfoAnnotation(info = "Меняет позицию точки", version = 2)
    public void move(double x, double y) {
        this.setX(x);
        this.setY(y);
        showCoordinatesAfterMove();
    }

    private void showCoordinatesAfterMove() {
        System.out.println("Координати цетральной точки: " + "X: " + this.x + "; Y: " + y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
