package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jack on 31/03/2017.
 */
public class Panel extends JPanel{
    BufferedImage image;
    public Panel(){
        try {
            image = ImageIO.read(new File("src/img/background5.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g){
        g.drawImage(image,0,0,null);
    }

    //@Override
    /*protected void paintComponent(Graphics g) {
        if (point != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 0.3f));
            g2d.setColor(Color.yellow);
            g2d.fillOval(point.x, point.y, 120, 60);
        }
    }*/
}
