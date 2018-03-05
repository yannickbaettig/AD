package ch.hslu.ad.sw01.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task {
    private final static Logger LOG = LogManager.getLogger(Task.class);
    private int task1Counter = 0;
    private int task2Counter = 0;
    private int task3Counter = 0;

    public void task(final int n) {
        task1(); task1(); task1(); task1();
        for (int i = 0; i < n; i++) {
            task2(); task2(); task2();
            for (int j = 0; j < n; j++) {
                task3(); task3();
            }
        }
    }

    private void task1() {
        task1Counter ++;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void task2() {
        task2Counter ++;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void task3() {
        task3Counter ++;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "task1Counter=" + task1Counter +
                ", task2Counter=" + task2Counter +
                ", task3Counter=" + task3Counter +
                '}';
    }
    }

