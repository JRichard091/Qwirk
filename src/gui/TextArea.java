package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jack on 03/04/2017.
 */
public class TextArea extends JTextArea {

    BufferedImage image;
    public TextArea(){
        try {
            image = ImageIO.read(new File("src/img/background3.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g){
        g.drawImage(image,0,0,null);
    }

}
