public interface Printable 
{
    public void print();

    public static void print(Printable[] varargs)
    {
        for (Printable object : varargs) 
        {
            object.print();
        }
    } 
}