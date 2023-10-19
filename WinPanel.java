import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WinPanel extends JPanel {

    private JLabel Winlabel;
    private JButton NewGamebutton;
    private JButton CloseGame;
    private JPanel Winpanel;
    private JFrame Winframe;
  


    public void winPanel(){
        Winframe = new JFrame("End of the game");
        Winpanel   = new JPanel();
        Winframe.add(Winpanel);
        Winlabel   = new JLabel("YOU WIN!");
        Winlabel.setBackground(Color.YELLOW);
        Winlabel.setFont(new Font("Verdana", 1, 20));
        Winlabel.setForeground(Color.RED);
        NewGamebutton  = new JButton("Start new game");
        CloseGame = new JButton("close the game");
        NewGamebutton.addActionListener((ActionListener) this);
        CloseGame.addActionListener((ActionListener) this);
        Winpanel.add(NewGamebutton);
        Winpanel.add(CloseGame);
    }
}




        
       // public static void main(String[] args) {
         //       int WinCount=0;
       // }




        





    

