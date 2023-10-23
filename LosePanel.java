import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/** Game over panel. */
public class LosePanel extends JPanel implements ActionListener{
    private JLabel loseLabel;
    private JButton newGamebutton;
    private JButton closeGame;


    /** Constructor. */
    public LosePanel() {
        super();
        loseLabel   = new JLabel("GAME OVER");
        loseLabel.setBackground(Color.CYAN);
        loseLabel.setFont(new Font("Verdana", 1, 20));
        loseLabel.setForeground(Color.BLACK);
        newGamebutton  = new JButton("Start new game");
        closeGame = new JButton("Close the game");
        newGamebutton.addActionListener((ActionListener) this);
        closeGame.addActionListener((ActionListener) this);

        add(loseLabel);
        add(newGamebutton);
        add(closeGame);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        
    }
}
    

