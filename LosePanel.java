import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LosePanel extends JPanel {
    //private MysteryWordPanel mysteryWordPanel;
    //private ManPanel manPanel;
    //private Hangman hangman;
    //private LetterEntryPanel letterEntryPanel;
    private JLabel Winlabel;
    private JButton NewGamebutton;
    private JButton CloseGame;
    private JPanel Winpanel;
   // private JFrame Winframe;
    private JFrame Loseframe;


    public void losePanel(){
        Loseframe = new JFrame("End of the game");
        Winpanel   = new JPanel();
        Loseframe.add(Winpanel);
        Winlabel   = new JLabel("GAME OVER");
        Winlabel.setBackground(Color.CYAN);
        Winlabel.setFont(new Font("Verdana", 1, 20));
        Winlabel.setForeground(Color.BLACK);
        NewGamebutton  = new JButton("Start new game");
        CloseGame = new JButton("Close the game");
        NewGamebutton.addActionListener((ActionListener) this);
        CloseGame.addActionListener((ActionListener) this);
        Winpanel.add(NewGamebutton);
        Winpanel.add(CloseGame);
    }
}
    

