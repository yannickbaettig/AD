package ch.hslu.ad.sw11_N4.Aufgabe3;

import java.util.concurrent.RecursiveTask;

public class ParallelFibonacci extends RecursiveTask<Integer> {
    private int n;

    public ParallelFibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 10) {
            return fiboRec(n);
        } else {
            ParallelFibonacci Fib1 = new ParallelFibonacci(n-1);
            Fib1.fork();
            ParallelFibonacci Fib2 = new ParallelFibonacci(n-2);
            return Fib2.invoke() + Fib1.join();
        }
    }


    private int fiboRec(int n) {
        if (n <= 1) { //Rekursionsbasis Stelle 0 = 1, Stelle 1 = 1
            return n;
        } else {
            return fiboRec(n - 1) + fiboRec(n - 2); //Rekursionsvorschrift
        }
    }
}
