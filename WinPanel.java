import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinPanel extends MainPanel {

  private JLabel Winlabel;
  private JButton NewGamebutton;
  private JButton CloseGame;
  private JPanel Winpanel;
  private JFrame Winframe;
  private MainPanel mainPanel;
  private Hangman frame;
  
  public void winPanel() {
    Winframe = new JFrame("End of the game");
    Winpanel = new JPanel();
    Winframe.add(Winpanel);
    Winlabel = new JLabel("YOU WIN!");
    Winlabel.setBackground(Color.YELLOW);
    Winlabel.setFont(new Font("Verdana", 1, 20));
    Winlabel.setForeground(Color.RED);

    NewGamebutton = new JButton("Start new game");
    CloseGame = new JButton("Close the game");

    NewGamebutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         
        frame.remove(Winframe);
        frame.add(mainPanel);
        mainPanel.setVisible(true);
        }
    });
      
 

    CloseGame.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Action for "Close the game" button in the win panel
            System.exit(0);
        }
    });

    Winpanel.add(Winlabel);
    Winpanel.add(NewGamebutton);
    Winpanel.add(CloseGame);
    Winframe.setVisible(false);
  }
}







        





    

