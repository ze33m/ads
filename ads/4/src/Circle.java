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

    public Circle(String color, boolean filled, Double radius)
    {
        super(color, filled);
        this.radius = radius;
    }

    public Double getRadius()
    {
        return this.radius;
    }

    public void setRaidus(Double radius)
    {
        this.radius = radius;
    }

    public double

}
