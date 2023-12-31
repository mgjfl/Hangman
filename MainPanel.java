import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** Panel containing the hanging man. */
public class MainPanel extends JPanel implements ActionListener {

    private Gallows gallow;
    private ManPanel manPanel;
    private MysteryWordPanel mysteryWordPanel;
    private LetterEntryPanel letterEntryPanel;
    private JPanel buttonPanel;
    private JButton restartGameButton;
    private JFrame frame;
    private LosePanel losePanel;
    private WinPanel winPanel;
    

    /** Standard initialisation. */
    MainPanel(JFrame fr, LosePanel lp, WinPanel wp) {

        // Storing references to several objects
        frame       = fr;
        losePanel   = lp;
        winPanel    = wp;

        // Storing a reference to this panel in the win/loss pop-ups
        losePanel.addMainPanel(this);
        winPanel.addMainPanel(this);

        // Adding all components to the game

        // The gallows.
        gallow = new Gallows();
        gallow.setPreferredSize(new Dimension(300, 500));
        this.add(gallow);

        // The hanging man.
        manPanel = new ManPanel();
        manPanel.setPreferredSize(new Dimension(150, 500));
        this.add(manPanel);


        // Button to restart the game.
        restartGameButton = new JButton("Restart game");
        restartGameButton.setBackground(Color.LIGHT_GRAY);
        restartGameButton.addActionListener(this);

        // Add buttons to panel
        buttonPanel = new JPanel();
        buttonPanel.add(restartGameButton, BorderLayout.EAST);
        buttonPanel.setBackground(Color.PINK);
        this.add(buttonPanel, BorderLayout.SOUTH);

        // The mystery word.
        mysteryWordPanel = new MysteryWordPanel();
        mysteryWordPanel.setPreferredSize(new Dimension(200, 200));
        mysteryWordPanel.setBackground(Color.LIGHT_GRAY);
        this.add(mysteryWordPanel);

        // The panel for insterting letter guesses.
        letterEntryPanel = 
            new LetterEntryPanel(frame, mysteryWordPanel, manPanel, this, losePanel, winPanel);
        letterEntryPanel.setPreferredSize(new Dimension(100, 50));
        letterEntryPanel.setBackground(Color.PINK);
        this.add(letterEntryPanel);

        // General styling
        setBackground(Color.PINK);
        FlowLayout layout = (FlowLayout) this.getLayout();
        layout.setHgap(0);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Handling the functionality to restart a game
        if (e.getActionCommand().equals("Restart game")) {

            System.out.println("\n\nRestarting the game...\n\n");
            manPanel.resetLevel();
            mysteryWordPanel.initialiseGame();
        }

        repaint();

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // We dynamically resize both the gallows and hanging man.
        int panelWidth = (int) this.getSize().getWidth() / 3;
        int maxPanelHeight = (int) this.getSize().getHeight();

        if (panelWidth * 5 / 3 <= maxPanelHeight) {
            manPanel.setPreferredSize(new Dimension(panelWidth / 2, panelWidth * 5 / 3));
            gallow.setPreferredSize(new Dimension(panelWidth, panelWidth * 5 / 3));
        } else {
            manPanel.setPreferredSize(new Dimension(maxPanelHeight * 3 / 10, maxPanelHeight));
            gallow.setPreferredSize(new Dimension(maxPanelHeight * 3 / 5, maxPanelHeight));
        }

    }    
}
