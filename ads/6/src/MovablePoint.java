public class MovablePoint implements Movable{
    Integer x;
    Integer y;
    Integer xSpeed;
    Integer ySpeed;
    
    public MovablePoint(int x, int y, int xSpeed, int ySpeed)
    {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public String toString()
    {
        return "Точка в координатах (" + x.toString() + "," + y.toString() + ") со скоростями (" + xSpeed.toString() + "," + ySpeed.toString() +")";
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
