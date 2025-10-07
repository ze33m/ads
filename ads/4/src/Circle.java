import java.lang.Math;

public class Circle extends Shape{
    protected Double radius;
    
    public Circle(){
        super();
        this.radius = 0.;
    }
    
    public Circle(Double radius)
    {
        super();
        this.radius = radius;
    }

    public Circle(Double radius, String color, boolean filled)
    {
        super(color, filled);
        this.radius = radius;
    }

    public Double getRadius()
    {
        return this.radius;
    }

    public void setRadius(Double radius)
    {
        this.radius = radius;
    }

    public double getArea()
    {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double getPerimeter()
    {
        return 2 * Math.PI * this.radius;
    }

    public String toString()
    {
        return "Круг с радиусом " + this.radius.toString();
    }
}
