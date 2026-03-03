public class Main2 {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[2];

        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(5.0, 10.0);

        double totalArea = 0;

        for (Shape shape : shapes) {
            double area = shape.getArea();
            totalArea += area;

            if (shape instanceof Circle) {
                System.out.println("円の面積: " + area);
            } else if (shape instanceof Rectangle) {
                System.out.println("長方形の面積: " + area);
            }
        }

        System.out.println("総面積: " + totalArea);
    }
}