package komendant.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapesFrame extends JFrame {

    private ShapeComponent shapeComponent;

    public ShapesFrame(){
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SHAPES");

        setLayout(new BorderLayout());
        shapeComponent = new ShapeComponent();
        add(shapeComponent, BorderLayout.CENTER);
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JButton flowerButton = new JButton("Flower");
        JButton butterflyButton = new JButton("Butterfly");
        JButton houseButton = new JButton("House");
        JButton iceCreamButton = new JButton("Ice-Cream");
        JButton clearButton = new JButton("Clear");
        leftPanel.add(flowerButton);
        leftPanel.add(butterflyButton);
        leftPanel.add(houseButton);
        leftPanel.add(iceCreamButton);
        leftPanel.add(clearButton);

        flowerButton.addActionListener(actionEvent -> shapeComponent.setShapeFlower());
        butterflyButton.addActionListener(actionEvent -> shapeComponent.setShapeButterfly());
        houseButton.addActionListener(actionEvent -> shapeComponent.setShapeHouse());
        iceCreamButton.addActionListener(actionEvent -> shapeComponent.setShapeIceCream());
        clearButton.addActionListener(actionEvent -> shapeComponent.setClear());

        add(leftPanel, BorderLayout.WEST);

    }

    public static void main(String[] args) {
        new ShapesFrame().setVisible(true);
    }
}
