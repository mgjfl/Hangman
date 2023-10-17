import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Panel containing the hanging man. */
public class MainPanel extends JPanel implements ActionListener {
    Gallow gallow;
    ManPanel manPanel;
    JPanel buttonPanel;
    JPanel letterPanel;
    JLabel letterlabel;
    JButton incrementPenaltyButton;
    JButton resetPenaltyButton;
    JButton submitButton;
    JTextField txtInput;
    Font newFont;



    /** Standard initialisation. */
    MainPanel() {
        setBackground(Color.BLUE);

        gallow = new Gallow();
        gallow.setPreferredSize(new Dimension(300, 500));
        this.add(gallow);

        
        manPanel = new ManPanel();
        manPanel.setPreferredSize(new Dimension(150, 500));
        this.add(manPanel);

        // adding letter placeholder
        letterPanel= new JPanel();
        letterlabel   = new JLabel("_ _ _ _ _");
        //newFont = new Font(letterlabel.getFont().getFontName(), Font.PLAIN, 30);
        //letterlabel.setFont(newFont);
        letterPanel.setBackground(Color.BLUE);
        letterPanel.add(letterlabel);

        this.add(letterPanel, BorderLayout.SOUTH);

        

        // Button to increment penalty level
        incrementPenaltyButton = new JButton("Increment");
        incrementPenaltyButton.addActionListener(this);

        // Button to reset penalty level
        resetPenaltyButton = new JButton("Reset");
        resetPenaltyButton.addActionListener(this);

        // Entry and button to submit entry
        txtInput = new JTextField(20);
        submitButton = new JButton("Enter");

        // Add buttons to panel
        buttonPanel = new JPanel();
        buttonPanel.add(incrementPenaltyButton, BorderLayout.WEST);
        buttonPanel.add(resetPenaltyButton, BorderLayout.EAST);
        //buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(txtInput, BorderLayout.SOUTH);
        buttonPanel.add(submitButton, BorderLayout.SOUTH);


        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {



        if (e.getActionCommand().equals("Increment")) {
            System.out.println("test");
            manPanel.incrementLevel();
        } else if (e.getActionCommand().equals("Reset")) {
            manPanel.penaltyLevel = 0;
        }

        repaint();

    }

    @Override
    public void paintComponent(Graphics g) {


        System.out.println("START - Repainting the main panel...\n");

        super.paintComponent(g);

        System.out.print("Main panel size: ");
        System.out.println(this.getSize());

        
        

        int panelWidth = (int) this.getSize().getWidth() / 3;
        int maxPanelHeight = (int) this.getSize().getHeight();

        if (panelWidth * 5 / 3 <= maxPanelHeight) {
            manPanel.setPreferredSize(new Dimension(panelWidth / 2, panelWidth * 5 / 3));
            gallow.setPreferredSize(new Dimension(panelWidth, panelWidth * 5 / 3));
        } else {
            manPanel.setPreferredSize(new Dimension(maxPanelHeight * 3 / 10, maxPanelHeight));
            gallow.setPreferredSize(new Dimension(maxPanelHeight * 3 / 5, maxPanelHeight));
        }
        // manPanel.paintComponent(g);

        System.out.println("\nEND - Repainting the main panel...\n");

    }
    
}
