package ch.hslu.ad.sw01.algorithmen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EuklidischerAlgorithmus {
    private final static Logger LOG = LogManager.getLogger(EuklidischerAlgorithmus.class);
    private static int counter2 = 0;

    public static int ggtIterativ1(int a, int b) {
        int counter = 0;
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
            counter += 1;
        }
        LOG.info(counter);
        return a;
    }


    public static int ggtIterativ2(int a, int b) {
        int counter = 0;
        while ((a != 0) && (b != 0)) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
            counter += 1;
        }
        LOG.info(counter);
        return (a + b); // Entweder a oder b ist 0!
    }


    public static int ggtRekursiv(final int a, final int b) {
        if (a > b) {
            counter2 += 1;
            return ggtRekursiv(a - b, b);
        } else {
            if (a < b) {
                counter2 += 1;
                return ggtRekursiv(a , b-a);
            } else {
                LOG.info(counter2);
                return a;
            }
        }
    }

}

