import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * The main class for the Hangman game, including a home screen to start a game 
 * a GUI to play the game and pop-ups for winning and losing the game.
 */
public class Hangman implements ActionListener {
    private JFrame frame;
    private MainPanel mainPanel;
    private JPanel startPanel;
    private LosePanel losePanel;
    private WinPanel winPanel;

    /**
     * Class constructor creates the frame.
     */
    Hangman() {
        // Create the frame , which is a window
        frame = new JFrame("Hangman Panel with start up button");
    }

    /**
     * Creates the objects for the start screen, GUI and win/loss pop-ups.
     */
    void setupGui() {

        // Pop-ups for winning and losing a game
        losePanel   = new LosePanel(frame);
        winPanel    = new WinPanel(frame);


        // The main panel employed by the GUI containing the hanging man,
        // a panel for the mysteryword and a place to insert letter guesses.
        mainPanel = new MainPanel(frame, losePanel, winPanel);
        

        // Now we create the components for the starting panel with a button to start a game.
        JLabel label   = new JLabel("Do you want to start a new game?");
        JButton button  = new JButton("yes");
        startPanel   = new JPanel();

        // We style the startin gpanel
        startPanel.setBackground(Color.PINK);
        label.setBackground(Color.PINK);
        label.setPreferredSize(new Dimension(400, 100));
        label.setFont(new Font("Verdana", 1, 19));
        button.setPreferredSize(new Dimension(100,  100));
        button.setFont(new Font("Verdana", 1, 30));
        button.setBackground(Color.LIGHT_GRAY);

        // Adding functionality to the button
        button.addActionListener(this);

        // Adding the components to the panel
        startPanel.add(label);
        startPanel.add(button);

        // We start with the starting panel occupying the frame
        frame.add(startPanel);
        
        // Setting several parameters
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // This handles the functionality of the "yes"-button
        if (e.getActionCommand().equals("yes")) {

            System.out.println("Starting the game");

            // Switchig to the main panel
            frame.remove(startPanel);
            frame.add(mainPanel);
            frame.setSize(800, 1000);
        }

    }


    public static void main(String[] args) {

        // Start the game
        new Hangman().setupGui();

    }
}