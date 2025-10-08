import java.awt.*;

class Circle extends Shape {
    int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius, radius);
    }
}
