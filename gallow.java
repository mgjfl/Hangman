import java.awt.*;
import javax.swing.*;

public class Gallow extends JPanel{
    JLabel label;
    JButton button;
    JPanel panel;

    Gallow(){
        // frame = new JFrame("Gallow");
        // frame.setSize(400, 400);
        // frame.add(new GallowsPanel());
        // frame.setVisible(true);
        setBackground(Color.WHITE);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        int size        = (int) getSize().getWidth() / 3;
        int thickness   = size / 5;
        int xShift      = size;
        int yShift      = size / 2;


        g2.setColor(Color.BLACK);

        g2.setStroke(new BasicStroke(thickness));
        
        // Base
        g2.drawLine(xShift, yShift + 3 * size, xShift + 2 * size, yShift + 3 * size); 

        // Vertical pole
        g2.drawLine(xShift + size, yShift + 3 * size, xShift + size, yShift); 

        // Horizontal pole
        g2.drawLine(xShift + size, yShift, xShift + 2 * size, yShift);  
        // frame.drawLine(150, 50, 150, 100); // Rope
    }
    
}
