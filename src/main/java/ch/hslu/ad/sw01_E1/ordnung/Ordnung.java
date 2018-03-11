package ch.hslu.ad.sw01_E1.ordnung;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ordnung {
    private final static Logger LOG = LogManager.getLogger(Ordnung.class);

    public static void wachstumsfunktionen (double n){
        LOG.info("log n: " + Math.log10(n));
        LOG.info("ld n: " + Math.log(n)/ Math.log(2));
        LOG.info("n*log n: " + n * Math.log10(n));
        LOG.info("n^2: " + Math.pow(n,2));
        LOG.info("n^3: " + Math.pow(n,3));
        LOG.info("2^n: " + Math.pow(2,n));
        LOG.info("3^n: " + Math.pow(3,n));
        LOG.info("n!: " + factorial(n));
    }

    private static double factorial (double input) {
        double fact = 1;
        double x;
        for (x = input; x >= 1; x --) {
            fact *= x;
        }
        return fact;
    }


    /*
    * b)
    *  1) 2^n
    *  2) ln(n)
    *  3) n^4
    *  4) n^3
    *  5) n!
    *  6) n
    *
    *
    * c)
    *   2,6,4,3,1,5
    *
    * d)
    *   1) 0.1s
    *   2) 1s
    *   3)
    *
    * e) log(n) / log(basis)
    *
    *
    * f) niedrigste -> höchste Laufzeit
    *   2,1,3
    * */

}
