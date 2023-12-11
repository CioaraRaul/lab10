package javaDesign;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingControlDemo9 {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public SwingControlDemo9(){
        prepareGUI();
    }
    public static void main(String[] args){
        SwingControlDemo9  swingControlDemo9 = new SwingControlDemo9();
        swingControlDemo9.showImageIconDemo();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("Java Swing Examples");
        mainFrame.setSize(200,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    // Returns an ImageIcon, or null if the path was invalid.
    private static ImageIcon createImageIcon(String path,
                                             String description) {
        java.net.URL imgURL = SwingControlDemo9.class.getResource(path);

        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    private void showImageIconDemo(){
        headerLabel.setText("Control in action: ImageIcon");
        ImageIcon icon = createImageIcon("/img/happy.jpg","Java");

        JLabel commentlabel = new JLabel("", icon,JLabel.CENTER);
        controlPanel.add(commentlabel);
        mainFrame.setVisible(true);
    }
}