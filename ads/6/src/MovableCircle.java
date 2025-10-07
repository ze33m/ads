public class MovableCircle implements Movable {
    private Integer radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius)
    {
        center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    public String toString()
    {
        return "Круг в координатах (" + center.x.toString() + "," + center.y.toString() + ") со скоростями (" + center.xSpeed.toString() + "," + center.ySpeed.toString() +") с радиусом " + radius.toString();
    }

    public void moveUp()
    {
        center.y += center.ySpeed;
    }
    public void moveDown()
    {
        center.y -= center.ySpeed;
    }
    public void moveRight()
    {
        center.x += center.xSpeed;
    }
    public void moveLeft()
    {
        center.x -= center.xSpeed;
    }


}
