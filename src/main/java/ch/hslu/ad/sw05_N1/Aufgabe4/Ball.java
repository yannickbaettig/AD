package ch.hslu.ad.sw05_N1.Aufgabe4;

import java.util.concurrent.ThreadLocalRandom;

public class Ball implements Runnable {
    private int size;
    private int r, g, b;
    private int xPosition;
    private int yPosition;
    private int min = 20;
    private int max = 50;

    @Override
    public void run() {

    }

    private int size(){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
