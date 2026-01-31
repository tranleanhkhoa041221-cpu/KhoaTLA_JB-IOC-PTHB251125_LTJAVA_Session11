package BaiTapKha1;

public class Circle extends Shape implements Drawable {
    private double radius;
    public Circle(){

    }

    public Circle(double radius) {
        super("Hình tròn");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Đã vẽ: " + getName());

    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
