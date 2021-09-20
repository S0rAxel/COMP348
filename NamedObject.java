public interface NamedObject
{
    public default String getName()
    {
        return this.getClass().getSimpleName();
    }   
}