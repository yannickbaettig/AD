package ch.hslu.ad.sw08_N3.Aufgabe4;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeTask implements Callable<BigInteger> {
    private BigInteger bi;
    private AtomicInteger counter;
    private AtomicInteger uselessNumbers;

    public PrimeTask(BigInteger bi, AtomicInteger counter, AtomicInteger uselessNumbers) {
        this.bi = bi;
        this.counter = counter;
        this.uselessNumbers = uselessNumbers;
    }

    @Override
    public BigInteger call() throws Exception {
        if (counter.get() < 20) {
            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                counter.incrementAndGet();
                return bi;
            }
        } uselessNumbers.incrementAndGet();

        return null;
        }
}
