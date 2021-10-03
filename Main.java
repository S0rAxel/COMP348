import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        Shape[] shapes = new Shape[7];
        List<Printable> objectsToPrint = new ArrayList<Printable>();

        System.out.println("\n Reading from file...\n");
        FileReader(shapes);
        
        System.out.println(" Printing shapes from file:\n");

        Printable.print(Arrays.copyOf(shapes, shapes.length, Printable[].class));

        System.out.println("\n Sorting Array:\n");

        Arrays.sort(shapes);

        objectsToPrint.clear();

        System.out.println(" Printing array sorted:\n");

        Printable.print(Arrays.copyOf(shapes, shapes.length, Printable[].class));

        /*Rectangle rectangle1 = new Rectangle(2, 3);
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
        }*/
    }

    static void FileReader(Shape[] shapes)
    {
        try 
        {
            String fileData = "";
            File file = new File("Shapes.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine())
            {
                fileData = fileReader.nextLine();
            }

            fileReader.close();
            
            String[] dataString = fileData.split(",");

            int j = 0;

            for (int i = 0 ; i < dataString.length ; i++)
            {   
                if (dataString[i].equals("Rectangle"))
                {
                    shapes[j] = Rectangle.parse(new String(dataString[i] + "," +  dataString[i+1] + "," + dataString[i+2]));
                    i += 2;
                }
                else if (dataString[i].equals("Circle"))
                {
                    shapes[j] = Circle.parse(new String(dataString[i] + "," + dataString[i+1]));
                    i += 1;
                } 

                j++;
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
