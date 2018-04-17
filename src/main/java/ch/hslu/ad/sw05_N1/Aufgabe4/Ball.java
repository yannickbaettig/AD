package ch.hslu.ad.sw05_N1.Aufgabe4;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Ball implements Runnable {
    private int size;
    private int r, g, b;
    private int xPosition;
    private int yPosition;
    private int min = 20;
    private int max = 50;
    private Color color;
    private int ySpeed;

    public Ball(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.r = (int) (Math.random()*256);
        this.g = (int) (Math.random()*256);
        this.b = (int) (Math.random()*256);
        this.color = new Color(r,g,b);
        this.size = ThreadLocalRandom.current().nextInt(min, max + 1);
        ySpeed = ThreadLocalRandom.current().nextInt(1, 5);

    }

    public void draw (Graphics g) {
        g.setColor(getColor());
        g.fillOval(getxPosition(), getyPosition(), getSize(), getSize()); //adds color to circle
    }

    @Override
    public void run() {
        while (yPosition + size/2 <= 400 - size) {
            yPosition += ySpeed;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public int getSize() {
        return size;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public Color getColor() {
        return color;
    }
}
