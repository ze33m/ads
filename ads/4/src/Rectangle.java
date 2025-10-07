import java.lang.Math;

public class Rectangle extends Shape{
    protected Double width;
    protected Double length;
    
    public Rectangle(){
        super();
        this.width = 0.;
        this.length = 0.;
    }
    
    public Rectangle(Double width, Double length)
    {
        super();
        this.width = width;
        this.length = length;
    }

    public Rectangle(Double width, Double length, String color, boolean filled)
    {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public Double getWidth()
    {
        return this.width;
    }

    public void setWidth(Double width)
    {
        this.width = width;
    }

    public Double getLength()
    {
        return this.length;
    }

    public void setLength(Double length)
    {
        this.length = length;
    }

    public double getArea()
    {
        return this.width * this.length;
    }

    public double getPerimeter()
    {
        return (this.width + this.length) * 2;
    }

    public String toString()
    {
        return "Прямоугольник с шириной " + this.width.toString() + " и высотой " + this.length.toString();
    }
}
 