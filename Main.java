package BaiTapKha1;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Rectangle(3, 4),
                new Circle(2.5),
                new Rectangle(5, 2)};
        for (Shape s : shapes) {
            s.displayInfo();
            System.out.printf("Diện tích: %.4f%n", s.getArea());
            System.out.printf("Chu vi: %.4f%n", s.getPerimeter());
            if (s instanceof Drawable) {
                ((Drawable) s).draw();
            }
            System.out.println("-------------------------");
        }
    }
}
