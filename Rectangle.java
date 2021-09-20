public class Rectangle extends PrintableObject implements Shape
{
    double sideX, sideY;

    public double getSideX() { return sideX; }
    public void setSideX(double value) { sideX = value; }

    public double getSideY() { return sideY; }
    public void setSideY(double value) { sideY = value; }

    public Rectangle() { };

    public Rectangle(double sideX, double sideY) 
    {
        this.sideX = sideX;
        this.sideY = sideY;
    }

    public double getPerimeter()
    {
        return (sideX * 2) + (sideY * 2);
    }

    public double getArea()
    {
        return sideX * sideY;
    }

    public static Rectangle parse(String rectangleString)
    {
        String[] rectangleParts = rectangleString.split(",");

        if ( rectangleParts[0].equals("Rectangle"))
        {
            return new Rectangle(Double.parseDouble(rectangleParts[1]), Double.parseDouble(rectangleParts[2]));
        }
        else    
        {
            return null;
        }
    }

    public String toString() 
    {
        return super.getName() + ", Side X: " + sideX + ", Side Y: " + sideY;
    }

    public void print()
    {
        System.out.println(this.toString());
    }
}
