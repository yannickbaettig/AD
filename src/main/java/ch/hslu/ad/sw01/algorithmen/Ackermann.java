package ch.hslu.ad.sw01.algorithmen;

public class Ackermann {
    public static int counter = 0;

    public static long ack ( long n, long m) {
        counter ++;
        if (n == 0) {
            return m + 1;
        } else if ((n > 0) && (m == 0)) {
            return ack(n-1, 1);
        } else if ((n > 0) && (m > 0)){
           return ack(n-1, ack(n,m-1));
        } else {
            return 0;
        }
    }
}

