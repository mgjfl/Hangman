import java.awt.*;
import javax.swing.*;

public class Hangman {
    JFrame frame;
    JLabel label;
    JButton button;
    JPanel panel;

    Gallow(){
        frame = new JFrame("Gallow");
        frame.setSize(400, 400);
        frame.add(new GallowsPanel());
        frame.setVisible(true);

    }

    void setUP() {
        frame.setColor(Color.WHITE);
        frame.fillRect(0, 0, getWidth(), getHeight());
        frame.setColor(Color.BLACK);

        frame.drawLine(50, 250, 150, 250); // Base
        frame.drawLine(100, 250, 100, 50); // Vertical pole
        frame.drawLine(100, 50, 150, 50);  // Horizontal pole
        frame.drawLine(150, 50, 150, 100); // Rope
    
    
}
