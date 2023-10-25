import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;



/** Panel where the user can insert a letter guess to the game. */
public class LetterEntryPanel extends JPanel {
    private MysteryWordPanel mysteryWordPanel;
    private ManPanel manPanel;
    private JTextField txtInput;
    private MainPanel mainPanel;
    
    private LosePanel losePanel;
    private WinPanel winPanel;
    private JFrame frame;



  
    /** 
     * Constructor, where connectivity with the MysteryWordPanel and
     * ManPanel is established to update them after letter guesses.
     * Updates the user when the game is won or lost.
     */
    LetterEntryPanel(JFrame fr, MysteryWordPanel mwp, ManPanel mp, MainPanel mainp, LosePanel lp, WinPanel wp) {
        frame               = fr;
        mysteryWordPanel    = mwp;
        manPanel            = mp;
        mainPanel           = mainp;
        losePanel           = lp;
        winPanel            = wp;
    
        // entry for the guessed letter
        txtInput = new JTextField(20);
        txtInput.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) { 

                // We limit the number of characters to 1
                if (txtInput.getText().length() >= 1) {
                    e.consume();
                } 

            }
        });
            



        JButton submitButton = new JButton("Enter");
        submitButton.setBackground(Color.LIGHT_GRAY);

        TextInputListener listener = new TextInputListener();

        txtInput.addActionListener(listener);
        submitButton.addActionListener(listener);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(txtInput, BorderLayout.CENTER);
        this.add(submitButton, BorderLayout.SOUTH);
  

    }

    /** ActionListener to submit letter guesses. */
    public class TextInputListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            String text = txtInput.getText();

            if (text.length() > 0) {

            char input = txtInput.getText().charAt(0);   // receive input from the text field
            System.out.println("Input: " + input);
                boolean letterIsGuessed = mysteryWordPanel.guessLetter(input);

                if (!letterIsGuessed) {
                    manPanel.incrementLevel();
                }

                txtInput.setText("");


            

                /*check for a win */
                if (letterIsGuessed && mysteryWordPanel.isGameWon()) {

                    System.out.println("\nYou have won the game!\n");
                    // Reset game parameters
                    manPanel.resetLevel();
                    mysteryWordPanel.chooseRandomMysteryWord();
               
                    frame.remove(mainPanel);
                    frame.add(winPanel);
                    frame.setSize(801, 1000);
                
                }
                 

                /*checking for a loss */
                if (!letterIsGuessed && manPanel.isGameLost()) {
                    System.out.println("\nGame over...\n");

                    // Reset game parameters
                    manPanel.resetLevel();
                    mysteryWordPanel.chooseRandomMysteryWord();
              
                    frame.remove(mainPanel);
                    frame.add(losePanel);
                    frame.setSize(801, 1000);
                }
            }

        }
                    
    }

}


        

     


    

