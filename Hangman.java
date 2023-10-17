import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Hangman implements ActionListener {
    private JFrame frame;
    private MainPanel mainPanel;
    private JPanel startPanel;


    Hangman() {
        // Create the frame , which is a window
        frame = new JFrame("Hangman Panel with start up button");
    }

    void setupGui() {


        // Man panel
        mainPanel = new MainPanel();
        

        // Create components , i.e., subclasses of JComponent
        JLabel label   = new JLabel("Do you want to start a new game?");
        JButton button  = new JButton("yes");
        button.addActionListener(this);
        startPanel   = new JPanel();

        // StartingButton
        frame.add(startPanel);
        
        startPanel.setBackground(Color.WHITE);
        label.setBackground(Color.WHITE);
        label.setPreferredSize(new Dimension(400, 100));
        label.setFont(new Font("Verdana", 1, 19));
        button.setPreferredSize(new Dimension(100,  100));
        button.setFont(new Font("Verdana", 1, 30));

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
}
