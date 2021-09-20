import java.util.List;
import java.util.ArrayList;

public class Main 
{
    public static void main(String[] args)
    {
        Rectangle rectangle1 = new Rectangle(2, 3);
        Rectangle rectangle2 = Rectangle.parse("Rectangle, 1, 4");
        Circle circle1 = new Circle(2);
        Circle circle2 = Circle.parse("Circle, 4");
        Circle circle3 = Circle.parse("Circle, 3");

        List<Printable> objectsToPrint = new ArrayList<Printable>();
        List<Shape> listOfShapes = new ArrayList<Shape>();

        listOfShapes.add(rectangle1);
        listOfShapes.add(rectangle2);
        listOfShapes.add(circle1);
        listOfShapes.add(circle2);

        objectsToPrint.add(rectangle1);
        objectsToPrint.add(rectangle2);
        objectsToPrint.add(circle1);
        objectsToPrint.add(circle2);
        objectsToPrint.add(circle3);

        Printable.print(objectsToPrint);

        for(Shape shape : listOfShapes)
        {
            System.out.println(shape.getName() + " - area: " + shape.getArea());
            System.out.println(shape.getName() + " - perimeter: "+ shape.getPerimeter());
        }
    }
}
