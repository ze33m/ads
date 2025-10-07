public class Square extends Rectangle {
    public Square()
    {
        super();
    }

    public Square(Double side)
    {
        super(side,side);
    }

    public Square(Double side, String color, boolean filled)
    {
        super(side, side, color, filled);
    }

    public Double getSide()
    {
        return this.length;
    }

    public void setSide(Double side)
    {
        this.length = side;
        this.width = side;
    }

    public void setLength(Double side)
    {
        setSide(side);
    }
    public void setWidth(Double side)
    {
        setSide(side);
    }

    public String toString()
    {
        return "Квадрат с стороной " + this.width.toString();
    }
}
