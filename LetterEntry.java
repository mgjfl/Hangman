import javax.swing.*;
import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class LetterEntry {
    private JTextField txtInput;
    private String input;
  
    



    public LetterEntry() {
        JFrame frame = new JFrame("Java Entry Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        txtInput = new JTextField(20);
        JButton submitButton = new JButton("Enter");

        submitButton.addActionListener(new txtInputListener());

        

        JLabel letterlabel   = new JLabel("_ _ _ _ _");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(letterlabel, BorderLayout.NORTH);
        panel.add(txtInput, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.SOUTH);
  

        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public class txtInputListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            input = txtInput.getText();   // receive input from the text field
            System.out.println("Input: " + input);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        
            new LetterEntry();
        });
    }
}
