package ch.hslu.ad.sw05_N1.Aufgabe2;

public class Quersumme {

    public static void main(String[] args) throws InterruptedException{

        AdditionTask AdditionTask1 = new AdditionTask(0,500);
        Thread Thread1 = new Thread(AdditionTask1, "Thread1");

        AdditionTask AdditionTask2 = new AdditionTask(800,1200);
        Thread Thread2 = new Thread(AdditionTask2, "Thread2");

        AdditionTask AdditionTask3 = new AdditionTask(400,1200);
        Thread Thread3 = new Thread(AdditionTask3, "Thread3");


        Thread1.start();
        Thread2.start();
        Thread3.start();
        Thread.sleep(500);
        Thread1.interrupt();
        Thread2.interrupt();
        Thread3.interrupt();
       /* AdditionTask1.stopRequest();
        AdditionTask2.stopRequest();
        AdditionTask3.stopRequest();
*/


    }
}



