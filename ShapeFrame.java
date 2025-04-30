import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ShapeFrame extends JFrame {

    ShapeFrame(Shape shape){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.add(new ShapePanel(shape));
    }

    public static void main(String[] args){
        
        Shape shape = new RectangularShape();
        Shape circle= new CircularShape();
        Shape triangle= new TriangularShape();
        new ShapeFrame(shape);
        new ShapeFrame(circle);
        new ShapeFrame(triangle);
    }
}

class ShapePanel extends JPanel {

    private Shape shape;

    ShapePanel(Shape shape){
        this.shape = shape;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        shape.draw((Graphics2D)g);
    }
}

abstract class Shape {
    abstract void draw(Graphics2D g);
}

class CircularShape extends Shape {

    @Override
    void draw(Graphics2D g){
        g.drawOval(50,50,100,100);
    }
}

class RectangularShape extends Shape {

    @Override
    void draw(Graphics2D g){
        g.drawRect(50,200,250,120);
    }
}

class SquaredShape extends Shape {

    @Override
    void draw(Graphics2D g){
        g.drawRect(150,150,200,200);
    }
}

class TriangularShape extends Shape {

    @Override
    void draw(Graphics2D g){
        int[] xPoints = {250,300,200};
        int[] yPoints = {150,250,250};
        g.drawPolygon(xPoints, yPoints, 3);
    }
}
