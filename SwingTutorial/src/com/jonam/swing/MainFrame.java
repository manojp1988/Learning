package com.jonam.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
    JLabel imageLabel = new JLabel();
    JLabel headerLabel = new JLabel();

    public MainFrame() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            contentPane = (JPanel) getContentPane();
            contentPane.setLayout(new BorderLayout());
            setSize(new Dimension(400, 300));
            setTitle("Your Job Crashed!");
            // add the header label
            headerLabel.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 16));
            headerLabel.setText("   Your job crashed during the save process!");
            contentPane.add(headerLabel, java.awt.BorderLayout.NORTH);
            // add the image label
//            ImageIcon ii = new ImageIcon(this.getClass().getResource(
//                    "yipeeee_snoopy.gif"));
//            imageLabel.setIcon(ii);
            Image image =  Toolkit.getDefaultToolkit().createImage("yipeeee_snoopy.gif");  
            //BufferedImage myPicture = ImageIO.read(new File("yipeeee_snoopy.gif"));
            imageLabel.setIcon(new ImageIcon(image));
            contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
            // show it
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}