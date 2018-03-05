package ch.hslu.ad.sw01.algorithmen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fibonacci {
    private static Map<Integer, Long> fibonacciNumbers = new HashMap<>();

    public static int fiboRec1(int n) {
        if (n <= 1) { //Rekursionsbasis Stelle 0 = 1, Stelle 1 = 1
            return n;
        } else {
            return fiboRec1(n - 1) + fiboRec1(n - 2); //Rekursionsvorschrift
        }
    }

    public static long fiboRec2(int n) {
        if (n <= 1) {
            return n;
        }
        if (fibonacciNumbers.containsKey(n)) {
            return fibonacciNumbers.get(n);
        } else {
            long number = fiboRec2(n - 1) + fiboRec2(n - 2);
            fibonacciNumbers.put(n, number);
            return number;
        }
    }



    public static int fiboIter(int n) {
        if (n <= 1) {
            return n;
        } else {
            int fib = 1;
            int prevfib = 1;

            for (int i = 2; i < n; i++) {
                int temp = fib;
                fib += prevfib;
                prevfib = temp;
            }
            return fib;
        }
    }
}
