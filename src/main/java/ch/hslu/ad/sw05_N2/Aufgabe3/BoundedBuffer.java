package ch.hslu.ad.sw05_N2.Aufgabe3;

import java.util.ArrayDeque;
import java.util.Deque;

public class BoundedBuffer<T> implements MyBuffer<T> {
    private Deque<T> buffer;
    private int initialSize;


    public BoundedBuffer(int size) {
        initialSize = size;
        this.buffer = new ArrayDeque<>(size);
    }

    @Override
    public synchronized T get() throws InterruptedException {
        while (empty()){
            this.wait();
        }
        T element = buffer.pollFirst();

        if (!full()){
            this.notifyAll();
        }
        return element;
    }

    @Override
    public synchronized T get(long millis) throws InterruptedException {
        while (empty()){
            this.wait(millis);
        }
        T element = buffer.pollFirst();

        if (!full()){
            this.notifyAll();
        }
        return element;
    }

    @Override
    public synchronized boolean put(T element) throws InterruptedException {
        while (size() == initialSize) {
            this.wait();
        }

        buffer.addLast(element);
        if (size() == 1) {
            this.notifyAll();
        }
        return true;
    }

    @Override
    public synchronized boolean put(T element, long millis) throws InterruptedException {
        while (size() == initialSize) {
            this.wait(millis);
            if (size() == initialSize) {
                return false;
            }
        }
        buffer.addLast(element);
        if (size() == 1) {
            this.notifyAll();
        }
        return true;
    }

    @Override
    public synchronized T front() {
        return buffer.getFirst();
    }

    @Override
    public synchronized T back() {
        return buffer.getLast();
    }

    @Override
    public synchronized boolean push(T element) throws InterruptedException {
        while (size() == initialSize) {
            this.wait();
        }

        buffer.addLast(element);
        if (size() == 1) {
            this.notifyAll();
        }
        return true;
    }

    @Override
    public synchronized T pop() throws InterruptedException {
        while (empty()){
            this.wait();
        }
        T element = buffer.pollLast();

        if (!full()){
            this.notifyAll();
        }
        return element;
    }

    @Override
    public synchronized boolean empty() {
        return (size() == 0);
    }

    @Override
    public synchronized boolean full() {
        return (size() == initialSize);
    }

    @Override
    public synchronized int size() {
        return buffer.size();
    }
}
