package komendant.scrabble;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class ScrabbleFrame extends JFrame {

    private final JTextField wordField;
    private final JLabel answerLabel;
    private Scrabble dictionary = new Scrabble();

    public ScrabbleFrame() throws FileNotFoundException {
        setSize(400, 300);
        setTitle("Scrabble Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        wordField = new JTextField();
        wordField.setPreferredSize(new Dimension(160, 40));
        JButton checkButton = new JButton("Check");

        checkButton.addActionListener(actionEvent -> checkWord());

        answerLabel = new JLabel();
        answerLabel.setPreferredSize(new Dimension(100, 40));
        answerLabel.setOpaque(true);
        answerLabel.setForeground(Color.white);
        add(wordField);
        add(checkButton);
        add(answerLabel);

    }

    public void checkWord() {
        boolean isInDictionary = dictionary.isWord(wordField.getText());
        answerLabel.setBackground(isInDictionary ? Color.green : Color.red);
        answerLabel.setText(String.valueOf(isInDictionary));
    }

    public static void main(String[] args) throws FileNotFoundException {
        ScrabbleFrame frame = new ScrabbleFrame();
        frame.setVisible(true);
    }

}
