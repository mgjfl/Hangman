import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class LetterEntryPanel extends JPanel {
    private MysteryWordPanel mysteryWordPanel;
    private ManPanel manPanel;
    private JTextField txtInput;
  
    



    LetterEntryPanel(MysteryWordPanel mwp, ManPanel mp) {

        mysteryWordPanel    = mwp;
        manPanel            = mp;
        
        txtInput = new JTextField(20);
        JButton submitButton = new JButton("Enter");
        submitButton.setBackground(Color.LIGHT_GRAY);

        submitButton.addActionListener(new txtInputListener());

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(txtInput, BorderLayout.CENTER);
        this.add(submitButton, BorderLayout.SOUTH);
  

    }

    public class txtInputListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            // TODO: Improve
            char input = txtInput.getText().charAt(0);   // receive input from the text field
            System.out.println("Input: " + input);
            boolean letterIsGuessed = mysteryWordPanel.guessLetter(input);

            if (!letterIsGuessed) {
                manPanel.incrementLevel();
            }

        }
    }
}
