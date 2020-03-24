package komendant.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapeComponent extends JComponent {

    private String shape = "";

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;


        g.translate(centerX, centerY);

        switch (shape) {
            case "Flower":
                drawFlower(g);
                break;
            case "Butterfly":
                drawButterfly(g);
                break;
            case "House":
                drawHouse(g);
                break;
            case "Ice Cream":
                drawIceCream(g);
                break;
        }

    }

    public void setShapeFlower(){
        shape = "Flower";
        repaint();
    }

    public void setShapeButterfly(){
        shape = "Butterfly";
        repaint();
    }

    public void setShapeHouse(){
        shape = "House";
        repaint();
    }

    public void setShapeIceCream(){
        shape = "Ice Cream";
        repaint();
    }

    public void setClear(){
        shape = "";
        repaint();
    }

    public void drawFlower(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(+5, 0, 20, 150);
        g.fillOval(+15, +50, 90, 60);
        g.fillOval(-80, +70, 90, 60);

        g.setColor(Color.YELLOW);
        g.fillOval(+15, -50, 95, 95);
        g.fillOval(+15, -150, 95, 95);
        g.fillOval(-85, -50, 95, 95);
        g.fillOval(-85, -150, 95, 95);

        g.setColor(Color.PINK);
        g.fillOval(-35, -100, 100, 100);
    }

    public void drawButterfly(Graphics g) {
        g.setColor(Color.blue);
        g.fillRoundRect(+30, -100, 100, 110, 60, 50);
        g.setColor(Color.white);
        g.fillOval(+55, -90, 20, 20);
        g.fillOval(+95, -85, 15, 15);
        g.fillOval(+75, -45, 20, 20);
        g.fillOval(+40, -55, 15, 15);

        g.setColor(Color.blue);
        g.fillRoundRect(-110, -100, 100, 110, 60, 50);
        g.setColor(Color.white);
        g.fillOval(-55, -90, 20, 20);
        g.fillOval(-95, -85, 15, 15);
        g.fillOval(-75, -45, 20, 20);
        g.fillOval(-40, -55, 15, 15);

        g.setColor(Color.CYAN);
        g.fillRoundRect(-90, 0, 80, 90, 60, 50);
        g.setColor(Color.white);
        g.fillOval(-75, +35, 20, 20);
        g.fillOval(-40, +15, 20, 20);
        g.fillOval(-40, +55, 20, 20);

        g.setColor(Color.CYAN);
        g.fillRoundRect(+30, 0, 80, 90, 60, 50);
        g.setColor(Color.white);
        g.fillOval(+75, +35, 20, 20);
        g.fillOval(+40, +15, 20, 20);
        g.fillOval(+40, +55, 20, 20);

        g.setColor(Color.red);
        g.fillOval(-20, -100, 60, 200);

        g.setColor(Color.black);
        g.drawLine(+15, -90, +35, -167);
        g.drawArc(+10, -175, 100, 100, 90, 30);

        g.drawLine(+5, -90, -35, -167);
        g.drawArc(-86, -167, 100, 100, 90, 30);
    }

    public void drawHouse(Graphics g){
        g.setColor(Color.PINK);
        g.fillRect(-60, -75, 150, 150);

        g.setColor(Color.GRAY);
        g.fillPolygon(new int[]{-75, 15, +105}, new int[]{-75, -175, -75},  3);

        g.setColor(Color.RED);
        g.fillRect(0, +25, 30, 50);

        g.setColor(Color.YELLOW);
        g.fillOval(+20, +45, 10, 10);

        g.setColor(Color.WHITE);
        g.fillRect(-35, -45, 35,35);
        g.fillRect(+35, -45, 35,35);
    }
    public void drawIceCream(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(-25, -173, 50, 50);
        g.setColor(Color.PINK);
        g.fillOval(-70,-140,140, 140);
        g.fillOval(-90,-100,175, 175);

        g.setColor(Color.ORANGE);
        g.fillPolygon(new int[]{-100,0,+100}, new int[]{0,+150,0},3);

    }
}
