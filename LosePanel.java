import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;






 /**
 * 
 */
class LosePanel extends JPanel implements ActionListener{
    private JLabel loselabel;
    private JButton NewGamebutton;
    private JButton CloseGame;
    private JPanel losepanel;
    private JFrame Loseframe;
    private Hangman frame;



    /**
     * 
     */
    public LosePanel() {
    super();
        Loseframe = new JFrame("End of the game");
        losepanel = new JPanel();
        Loseframe.add(losepanel);
        losepanel.setPreferredSize(getPreferredSize());
        loselabel = new JLabel("GAME OVER");
        loselabel.setBackground(Color.CYAN);
        loselabel.setFont(new Font("Verdana", 1, 20));
        loselabel.setForeground(Color.BLACK);
        
        NewGamebutton = new JButton("Start new game");
        CloseGame = new JButton("Close the game");
        //NewGamebutton.addActionListener((ActionListener) this);
        //CloseGame.addActionListener((ActionListener) this);
        losepanel.setLayout(new FlowLayout(ABORT));
        losepanel.add(loselabel);
        losepanel.add(NewGamebutton);
        losepanel.add(CloseGame);
        
    
        NewGamebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.frame.removeAll();
                MainPanel mainPanel = new MainPanel(frame);
                frame.frame.add(mainPanel);
            }
        });
    
        
        CloseGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
}


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
    





    

