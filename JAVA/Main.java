import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main 
{
    public static void main(String[] args)
    {
        Shape[] shapes = new Shape[7];

        FileReaderer(shapes);
        
        System.out.println(" Printing shapes from file:\n");

        Printable.print(Arrays.copyOf(shapes, shapes.length, Printable[].class));

        System.out.println("\n Sorting Array:\n");

        Arrays.sort(shapes, new Comparator()
        {
            public int compare(Object o1, Object o2) 
            {
               if (o1 instanceof Shape && o2 instanceof Shape) 
               {
                    Shape s1 = (Shape)o1;
                    Shape s2 = (Shape)o2;
                        
                    if (s1.getName().equals(s2.getName()))
                    {
                        if (s1.getArea() > s2.getArea())
                        {
                            return 1;
                        }
                        else if (s1.getArea() < s2.getArea())
                        {
                            return -1;
                        }
                        else 
                        {
                            return 0;
                        }
                    }
                    else
                    {
                         return s1.getName().compareTo(s2.getName());
                    }
               } 

               return 0;    
            }
        });

        System.out.println(" Printing sorted array: \n");

        Printable.print(Arrays.copyOf(shapes, shapes.length, Printable[].class));
    }

    static void FileReaderer(Shape[] shapes)
    { 
        System.out.print("\n Input the name of the file to read: ");
        
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();
        
        System.out.println("\n Reading from file...\n");
        
        String fileData = null;

        try (BufferedReader buffReader = new BufferedReader(new FileReader(filename)))
        {
            //while((fileData = buffReader.readLine()) != null) 
            
            fileData = buffReader.readLine();

        } catch (IOException e) {
            System.out.println("\n - ERROR: File not found. - \n");
            e.printStackTrace();
        }

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
    }
}

/*
    Question: Despite the fact that all shapes are either Rectangle or Circle, you cannot pass
    an a Shape[] array as Printable[] to the print method. Why?
        Because dispite the fact that circle and rectangle are shapes, the Shape class does not extend from the Printable class, as Shape is an interface that it is implement 
        by the circle and rectangle.
*/
