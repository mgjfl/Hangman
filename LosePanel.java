import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LosePanel extends MainPanel {

    private JLabel loselabel;
    private JButton NewGamebutton;
    private JButton CloseGame;
    private JPanel losepanel;
    private JFrame Loseframe;
    private MainPanel mainPanel;
    private Hangman frame;


 /**
 * 
 */
public void losePanel() {

    Loseframe = new JFrame("End of the game");
    losepanel = new JPanel();
    Loseframe.add(losepanel);
    loselabel = new JLabel("GAME OVER");
    loselabel.setBackground(Color.CYAN);
    loselabel.setFont(new Font("Verdana", 1, 20));
    loselabel.setForeground(Color.BLACK);
    
    NewGamebutton = new JButton("Start new game");
    CloseGame = new JButton("Close the game");
    
    NewGamebutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.remove(Loseframe);
            frame.add(mainPanel);
            mainPanel.setVisible(true);
        }
    });
    
    CloseGame.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Action for "Close the game" button
            System.exit(0);
        }
    });
    
    losepanel.add(loselabel);
    losepanel.add(NewGamebutton);
    losepanel.add(CloseGame);
    Loseframe.setVisible(false);


}
    
}




    

