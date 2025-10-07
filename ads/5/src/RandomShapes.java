import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomShapes extends JPanel {

    private List<Shape> shapes;

    public RandomShapes() {
        shapes = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            int x = rand.nextInt(400);
            int y = rand.nextInt(400);
            if (rand.nextBoolean()) {
                int radius = rand.nextInt(50) + 10;
                shapes.add(new Circle(x, y, radius));
            } else {
                int width = rand.nextInt(100) + 10;
                int height = rand.nextInt(100) + 10;
                shapes.add(new Rectangle(x, y, width, height));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Случайные фигуры");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        RandomShapes panel = new RandomShapes();
        frame.add(panel);

        frame.setVisible(true);
    }
}