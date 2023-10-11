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
