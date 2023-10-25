import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A panel containing the (static) parts of the gallows.
 */
public class Gallows extends JPanel {
    JLabel label;
    JPanel panel;

    /** Constructor. */
    public Gallows() {

        // Some styling
        setBackground(Color.PINK);

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Some parameters used for relative positioning and dynamic resizing.
        int size        = (int) getSize().getWidth() / 3;
        int thickness   = size / 5;
        int xShift      = size;
        int yShift      = size / 2;


        // Setting the line style
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(thickness));
        
        // Base
        g2.drawLine(xShift, yShift + 3 * size, xShift + 2 * size, yShift + 3 * size); 

        // Vertical pole
        g2.drawLine(xShift + size, yShift + 3 * size, xShift + size, yShift); 

        // Horizontal pole
        g2.drawLine(xShift + size, yShift, xShift + 2 * size, yShift);  

    } 
}
