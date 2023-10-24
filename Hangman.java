import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * The main class for the Hangman game, including a home screen to start a game 
 * and a GUI to play the game.
 */
public class Hangman implements ActionListener {
    JFrame frame;
    private MainPanel mainPanel;
    private JPanel startPanel;

    /**
     * Class constructor contains the frame.
     */
    Hangman() {
        // Create the frame , which is a window
        frame = new JFrame("Hangman Panel with start up button");
    }

    /**
     * Builds the home screen with start button and the GUI to play the game.
     */
    void setupGui() {


        // Man panel
        mainPanel = new MainPanel(this);
        

        // Create components , i.e., subclasses of JComponent
        JLabel label   = new JLabel("Do you want to start a new game?");
        JButton button  = new JButton("yes");
        button.addActionListener(this);
        startPanel   = new JPanel();

        // StartingButton
        frame.add(startPanel);
        
        startPanel.setBackground(Color.PINK);
        label.setBackground(Color.PINK);
        label.setPreferredSize(new Dimension(400, 100));
        label.setFont(new Font("Verdana", 1, 19));
        button.setPreferredSize(new Dimension(100,  100));
        button.setFont(new Font("Verdana", 1, 30));
        button.setBackground(Color.LIGHT_GRAY);

        startPanel.add(label);
        startPanel.add(button);

        

        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {



        if (e.getActionCommand().equals("yes")) {
            System.out.println("Starting the game");
            frame.remove(startPanel);
            frame.add(mainPanel);
            frame.setSize(800, 1000);
        }

        // repaint();

    }



    public static void main(String[] args) {
        new Hangman().setupGui();
    }

    public void remove(MainPanel mainPanel2) {
    }


}
