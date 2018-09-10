package ch.hslu.ad.sw05_N1.Aufgabe3;

public class JoinAndSleepMain {

    public static void main(String[] args) {
        Thread t3 = new Thread(new JoinAndSleep(null,4000,false));
        Thread t2 = new Thread(new JoinAndSleep(t3, 3000,false));
        Thread t1 = new Thread(new JoinAndSleep(t2, 2000, false));


        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
