package BaiTapKha1;

public class Rectangle extends Shape implements Drawable {
    private double width;
    private double height;
    public Rectangle() {

    }
    public Rectangle(double width, double height) {
        super("Hình chữ nhật");
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Đã vẽ: " + getName());

    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) / 2;
    }
}
