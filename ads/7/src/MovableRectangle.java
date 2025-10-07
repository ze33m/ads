public class MovableRectangle implements Movable{
    Integer x;
    Integer y;
    Integer a;
    Integer b;
    Integer xSpeed;
    Integer ySpeed;
    
    public MovableRectangle(int a, int b, int x, int y, int xSpeed, int ySpeed)
    {
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public String toString()
    {
        return "Прямоугольник в координатах (" + x.toString() + "," + y.toString() + ") со скоростями (" 
                + xSpeed.toString() + "," + ySpeed.toString() +") со сторонами " + a.toString() + " и " + b.toString();
    }

    public void moveUp()
    {
        this.y += this.ySpeed;
    }
    public void moveDown()
    {
        this.y -= this.ySpeed;
    }
    public void moveRight()
    {
        this.x += this.xSpeed;
    }
    public void moveLeft()
    {
        this.x -= this.xSpeed;
    }
    
}
