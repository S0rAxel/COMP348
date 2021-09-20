import java.util.List;

public interface Printable 
{
    public void print();

    public static void print(List<Printable> printableObjects)
    {
        for (Printable printableObject : printableObjects) 
        {
            printableObject.print();
        }
    } 
}