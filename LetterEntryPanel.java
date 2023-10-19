import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;





public class LetterEntryPanel extends JPanel {
    private MysteryWordPanel mysteryWordPanel;
    private ManPanel manPanel;
    private JTextField txtInput;
    private MainPanel mainPanel;
    private WinPanel WinPanel;
    private LosePanel losePanel;

  
    



    LetterEntryPanel(MysteryWordPanel mwp, ManPanel mp) {

        mysteryWordPanel    = mwp;
        manPanel            = mp;
        
        txtInput = new JTextField(20);
        txtInput.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) { 
                if (txtInput.getText().length() >= 1 ) // limit textfield to 1 character
                    e.consume(); 
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

    public class TextInputListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String text = txtInput.getText();

            if (text.length() > 0) {
                // TODO: Improve
                char input = txtInput.getText().charAt(0);   // receive input from the text field
                System.out.println("Input: " + input);
                boolean letterIsGuessed = mysteryWordPanel.guessLetter(input);

                if (!letterIsGuessed) {
                    manPanel.incrementLevel();
                }

                txtInput.setText("");

                // Check if the game is lost or won

               // Check for a win
               if (letterIsGuessed && mysteryWordPanel.isGameWon()) {
               this.remove(mainPanel);
               this.add(WinPanel);
               }

               // Check for a loss
               if (!letterIsGuessed && manPanel.isGameLost()) {
               this.remove(mainPanel);
               this.add(losePanel);
               }
            }

        }

        private void add(WinPanel winPanel) {
        }

        private void add(LosePanel losePanel) {
        }

        private void remove(MainPanel mainPanel) {
        }
    }
}
