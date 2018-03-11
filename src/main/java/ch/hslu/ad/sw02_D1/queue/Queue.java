package ch.hslu.ad.sw02_D1.queue;

public interface Queue<T> {

    void enqueue(T data);

    T dequeue();

    boolean isEmpty();

    boolean isFull();

}
