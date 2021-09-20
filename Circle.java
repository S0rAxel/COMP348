public class Circle extends PrintableObject implements Shape
{
    private double radius;

    public double getRadius() { return radius; }
    public void setRadius(double value) { radius = value; }

    public Circle() { }

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }

    public double getArea() 
    {
        return Math.PI * Math.pow(radius, 2);
    }

    public static Circle parse(String circleString)
    {
        String[] circleParts = circleString.split(",");

        if (circleParts[0].equals("Circle")) 
        {
            return new Circle(Double.parseDouble(circleParts[1]));
        }
        else
        {
            return null;
        }
    }

    @Override
    public String toString()
    {
        return super.getName() + ", radius: " + this.radius;
    }

    @Override 
    public String getName()
    {
        return this.getClass().getSimpleName().toUpperCase();
    }

    public void print() 
    {
        System.out.println(this.toString());
    }
}
