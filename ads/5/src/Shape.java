import java.awt.*;
import java.util.Random;

abstract class Shape {
    Color color;
    int x, y; 

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = getRandomColor();
    }


    abstract void draw(Graphics g);

    public Color getRandomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
}