package ch.hslu.ad.sw08_N3.Aufgabe3;

import java.util.concurrent.Callable;

public class CounterTask implements Callable<Integer> {
    Count counter;

    public CounterTask(Count counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10000000; i++) {
            counter.increment();
            counter.decrement();
        }
        return counter.get();
    }
}
