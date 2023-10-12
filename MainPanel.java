import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/** Panel containing the hanging man. */
public class MainPanel extends JPanel implements ActionListener {
    Gallow gallow;
    ManPanel manPanel;
    JPanel buttonPanel;
    JButton incrementPenaltyButton;
    JButton resetPenaltyButton;

    /** Standard initialisation. */
    MainPanel() {
        setBackground(Color.BLUE);

        gallow = new Gallow();
        gallow.setPreferredSize(new Dimension(300, 500));
        this.add(gallow);

        
        manPanel = new ManPanel();
        manPanel.setPreferredSize(new Dimension(150, 500));
        this.add(manPanel);

        // Button to increment penalty level
        incrementPenaltyButton = new JButton("Increment");
        incrementPenaltyButton.addActionListener(this);

        // Button to reset penalty level
        resetPenaltyButton = new JButton("Reset");
        resetPenaltyButton.addActionListener(this);

        // Add buttons to panel
        buttonPanel = new JPanel();
        buttonPanel.add(incrementPenaltyButton, BorderLayout.WEST);
        buttonPanel.add(resetPenaltyButton, BorderLayout.EAST);

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
