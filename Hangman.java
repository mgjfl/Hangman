import java.awt.*;
import javax.swing.*;

public class Hangman {
    JFrame frame;
    JLabel label;
    JButton button;
    JPanel panel;
    int penaltyLevel;

    Hangman() {
        // Create the frame , which is a window
        frame = new JFrame("Hangman Panel");
    }

    void setupGui() {


        // Man panel
        MainPanel mainPanel = new MainPanel();
        frame.add(mainPanel);
        frame.setSize(400, 500);


        // To make closing the window , stop the program :

        frame = new JFrame("Start up button");
        // Create components , i.e., subclasses of JComponent
        label = new JLabel("Do you want to start a new game?");
        button = new JButton("yes");
        panel = new JPanel();
    }

    void setupGui() {
        // StartingButton
        frame.add(panel);
        frame.add(button, BorderLayout.SOUTH);
        panel.setBackground(Color.WHITE);
        label.setBackground(Color.WHITE);
        label.setPreferredSize(new Dimension(400, 100));
        label.setFont(new Font("Verdana",1,19));
        button.setPreferredSize(new Dimension(100, 100));
        button.setFont(new Font("Verdana",1,30));
        frame.add(label, BorderLayout.NORTH);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Renders the gallow.
     */
    void addGallow() {

        

    }

    public static void main(String[] args) {
        new Hangman().setupGui();
    }
}
