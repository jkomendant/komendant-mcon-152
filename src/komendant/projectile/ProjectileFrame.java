package komendant.projectile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProjectileFrame  extends JFrame {

    private JTextArea projectileCoordinates;
    private JTextField velocity;
    private JTextField angle;

    private ArrayList<Projectile> projectileList = new ArrayList<>();

    public ProjectileFrame(){
        setSize(300,400);
        setTitle("Projectile");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        projectileCoordinates = new JTextArea();
        velocity = new JTextField();
        angle = new JTextField();
        JButton calculateButton = new JButton("Calculate");

        calculateButton.addActionListener(actionEvent -> calculate());

        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("angle");

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3,2));
        leftPanel.add(velocityLabel);
        leftPanel.add(velocity);
        leftPanel.add(angleLabel);
        leftPanel.add(angle);
        leftPanel.add(calculateButton);

        add(projectileCoordinates, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);

    }

    public void calculate() {
        if(projectileCoordinates.contains(0,0))
        {
            projectileCoordinates.setText("");
        }
        Projectile projectile = new Projectile(Double.parseDouble(angle.getText()),
                Double.parseDouble(velocity.getText()));
        for (int i = 0; i <= 30; i++) {
            projectileList.add(projectile);
        }
        for (int j = 0; j < projectileList.size(); j++) {
            projectileCoordinates.append(projectile.toString() + "\n");
            projectile.increaseTime(1);
        }
    }

    public static void main(String[] args) {
        new ProjectileFrame().setVisible(true);
    }

}
