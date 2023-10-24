import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

 

/** Win panel. */
public class WinPanel extends JPanel implements ActionListener {
    private JLabel loseLabel;
    private JButton newGamebutton;
    private JButton closeGame;
    private MainPanel mainPanel;
    private JFrame frame;


    /** Constructor. */
    public WinPanel(JFrame f) {
        super();

        frame = f;
        loseLabel   = new JLabel("YOU HAVE WON THE GAME!");
        loseLabel.setBackground(Color.CYAN);
        loseLabel.setFont(new Font("Verdana", 1, 20));
        loseLabel.setForeground(Color.BLACK);
        newGamebutton  = new JButton("Start new game");
        closeGame = new JButton("Close the game");

        add(loseLabel);
        add(newGamebutton);
        add(closeGame);

        setBackground(Color.BLUE);

        closeGame.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                // Action for "Close the game" button in the win panel
                System.exit(0);
        }
        });

        newGamebutton.addActionListener(this);

    }

    public void addMainPanel(MainPanel mp) {
        mainPanel = mp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Start a new game
        frame.remove(this);
        frame.add(mainPanel);
        frame.setSize(800, 1000);
    }

    
  

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
    }
}