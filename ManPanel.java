import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;


class ManPanel extends JPanel {
    private int penaltyLevel;

    

    /**
     * Initialize the man panel.
     * @param level Denotes the number of previous incorrect guesses.
     */
    ManPanel(int level) {
        penaltyLevel = level;
        setBackground(Color.PINK);
        
    }

    ManPanel() {
        this(0);
    }

    void incrementLevel() {
        penaltyLevel++;
        repaint();
    }

    void resetLevel() {
        penaltyLevel = 0;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;


        int size        = (int) getSize().getWidth() / 3;
        int thickness   = size / 5;
        int xShift      = size;
        int yShift      = 3 * size;

        
        

        // Body
        if (penaltyLevel >= 2) {
            g2.setColor(Color.black);
            g2.fillOval(xShift, yShift + size, size, 2 * size);
        }

        // Rope
        if (penaltyLevel >= 7) {

            g2.setColor(new Color(165, 42, 42)); // Brown

            // Draw rope
            g2.setStroke(new BasicStroke(thickness / 2));
            g2.drawOval(xShift + size / 4, yShift + size - thickness / 3, size / 2, thickness);
            g2.drawLine(xShift + size / 2, yShift + thickness, xShift + size / 2, size);


        }

        // Horizontal part of gallow
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(thickness * 2));
        g2.drawLine(-size, size, xShift + size, size); 

        // Head
        if (penaltyLevel >= 1) {
            g2.setColor(Color.black);
            g2.fillOval(xShift, yShift + thickness / 2, size, size);
        }



        // Right arm
        if (penaltyLevel >= 3) {
            
            double x1 = xShift + 0.9 * size;
            double y1 = yShift + 1.5 * size;

            double x2 = x1 + 0.75 * size;
            double y2 = y1 - 0.75 * size;

            g2.setStroke(new BasicStroke(thickness));
            g2.draw(new Line2D.Float((int) x1, (int) y1, (int) x2, (int) y2));



        }

        // Left arm
        if (penaltyLevel >= 4) {

            double x1 = xShift + 0.1 * size;
            double y1 = yShift + 1.5 * size;

            double x2 = x1 - 0.75 * size;
            double y2 = y1 - 0.75 * size;

            g2.setStroke(new BasicStroke(thickness));
            g2.draw(new Line2D.Float((int) x1, (int) y1, (int) x2, (int) y2));

        }

        // Right leg
        if (penaltyLevel >= 5) {
            
            double x1 = xShift + 0.9 * size;
            double y1 = yShift + 2.5 * size;

            double x2 = x1 + 0.25 * size;
            double y2 = y1 + size;

            double x3 = x2 + 0.2 * size;

            g2.setStroke(new BasicStroke(thickness));
            g2.draw(new Line2D.Float((int) x1, (int) y1, (int) x2, (int) y2));

            // Foot
            g2.draw(new Line2D.Float((int) x2, (int) y2, (int) x3, (int) y2));

        }

        // Left leg
        if (penaltyLevel >= 6) {

            double x1 = xShift + 0.1 * size;
            double y1 = yShift + 2.5 * size;

            double x2 = x1 - 0.25 * size;
            double y2 = y1 + size;

            double x3 = x2 - 0.2 * size;


            g2.setStroke(new BasicStroke(thickness));
            g2.draw(new Line2D.Float((int) x1, (int) y1, (int) x2, (int) y2));

            // Foot
            g2.draw(new Line2D.Float((int) x2, (int) y2, (int) x3, (int) y2));

        }




    }

    
}