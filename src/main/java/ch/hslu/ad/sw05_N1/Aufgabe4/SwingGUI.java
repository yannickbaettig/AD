package ch.hslu.ad.sw05_N1.Aufgabe4;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class SwingGUI {


        public static void main(String[] args) {
            // Creating instance of JFrame
            JFrame frame = new JFrame("My First Swing Example");
            // Setting the width and height of frame
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Creating panel. This is same as a div tag in HTML
         * We can create several panels and add them to specific
         * positions in a JFrame. Inside panels we can add text
         * fields, buttons and other components.
         */
            JPanel panel = new BallPanel();
            // adding panel to frame
            frame.add(panel, BorderLayout.CENTER);

            // Setting the frame visibility to true
            frame.setVisible(true);
        }
    }

