public class Ellipse extends Point {
    private double radiusX;
    private double radiusY;

    public Ellipse(double centerX, double centerY) {
        super(centerX, centerY);
        this.radiusX = 1;
        this.radiusY = 1;
    }

    public Ellipse(double centerX, double centerY, double radiusX, double radiusY) {
        super(centerX, centerY);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public double getRadiusX() {
        return radiusX;
    }

    public void setRadiusX(double radiusX) {
        this.radiusX = radiusX;
    }

    public double getRadiusY() {
        return radiusY;
    }

    public void setRadiusY(double radiusY) {
        this.radiusY = radiusY;
    }

    @Override
    @InfoAnnotation(info = "Меняет позицию еллипса относительно центра", version = 2)
    public void move(double x, double y) {
        super.move(x, y); //установить новый центр
        //получаем новые координаты эллипса
        for (int i = 0; i <= 360; i++) {
         double xPosition = super.getX() + Math.sin(i * (Math.PI / 180)) * this.radiusX;
         double yPosition = super.getY() + Math.cos(i) * this.radiusY;
        }
        System.out.println("Новый эллипс построен");
        //Что бы не выводить 360 раз координаты каждой точки эллипса
        //просто для примера, буду выводить что эллипс построен относительно нового центра
        //поэтому перменные xPosition и yPosition нигде не используються
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "radiusX=" + radiusX +
                ", radiusY=" + radiusY +
                ", "+ super.toString();
    }
}
