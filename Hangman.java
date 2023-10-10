import java.awt.*;
import javax.swing.*;

public class Hangman {
    JFrame frame;
    JLabel label;
    JButton button;
    JPanel panel;

    Hangman() {
        // Create the frame , which is a window
        frame = new JFrame("Some Components ");
        // Create components , i.e., subclasses of JComponent
        label = new JLabel("What 's my color?");
        button = new JButton("Ok");
        panel = new JPanel();
    }

    void setupGui() {
        // Places the panel in the center of the window
        frame.add(panel);
        // Places the button at the bottom of the window
        frame.add(button, BorderLayout.SOUTH);
        Color yellow = new Color(255, 255, 0);
        panel.setBackground(yellow);
        label.setBackground(Color.PINK);
        label.setOpaque(true);
        // Places the label at the top of the window
        frame.add(label, BorderLayout.NORTH);
        frame.setSize(400, 300);
        // To make closing the window , stop the program :
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void addGallow() {

    }

    // Add various body parts

    public static void main(String[] args) {
        new Hangman().setupGui();
    }
}
