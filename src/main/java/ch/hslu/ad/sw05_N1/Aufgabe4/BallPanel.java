package ch.hslu.ad.sw05_N1.Aufgabe4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BallPanel extends JPanel implements MouseListener, ActionListener {
    private List<Ball> BallList = Collections.synchronizedList(new ArrayList<>());

    Timer timer=new Timer(20, this);

    public BallPanel() {
        this.addMouseListener(this);
        timer.start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball b: BallList) {
            b.draw(g);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Ball ball = new Ball(e.getX(),e.getY());
        BallList.add(ball);
        System.out.print("Mouse pressed ");
        Thread t = new Thread(ball);
        t.start();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==timer){
            repaint();// this will call at every 1 second
        }
    }
}
