public abstract class PrintableObject implements NamedObject, Printable
{
    public String toString()
    {
        return getName();
    }
}
