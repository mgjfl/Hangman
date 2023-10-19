import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class WinPanel {
    JLabel Winlabel;
    JButton NewGamebutton;
    JButton CloseGame;
    JPanel Winpanel;
    JFrame frame;


    WinPanel(){

            frame = new JFrame("End of the game");
            Winpanel   = new JPanel();
            frame.add(Winpanel);
            Winlabel   = new JLabel("YOU WIN!");
            Winlabel.setBackground(Color.YELLOW);
            Winlabel.setFont(new Font("Verdana", 1, 20));
            Winlabel.setForeground(Color.RED);
            NewGamebutton  = new JButton("Start new game");
            CloseGame = new JButton("close the game")
            NewGamebutton.addActionListener((ActionListener) this);
            CloseGame.addActionListener((ActionListener) this);
            Winpanel.add(NewGamebutton);
            Winpanel.add(CloseGame);

     }

    void LosePanel(){
            frame = new JFrame("End of the game");
            Winpanel   = new JPanel();
            frame.add(Winpanel);
            Winlabel   = new JLabel("GAME OVER");
            Winlabel.setBackground(Color.CYAN);
            Winlabel.setFont(new Font("Verdana", 1, 20));
            Winlabel.setForeground(Color.BLACK);
            NewGamebutton  = new JButton("Start new game");
            CloseGame = new JButton("Close the game")
            NewGamebutton.addActionListener((ActionListener) this);
            CloseGame.addActionListener((ActionListener) this);
            Winpanel.add(NewGamebutton);
            Winpanel.add(CloseGame);
    }

        




}
    

