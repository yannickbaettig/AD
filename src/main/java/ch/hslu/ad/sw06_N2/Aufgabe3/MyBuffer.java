package ch.hslu.ad.sw06_N2.Aufgabe3;

public interface MyBuffer<T> {

    public T get() throws InterruptedException;

    public T get(long millis) throws InterruptedException;

    public boolean put(T element) throws InterruptedException;

    public boolean put(T element, long millis) throws InterruptedException;

    public T front();

    public T back();

    public boolean push(T element) throws InterruptedException;

    public T pop() throws InterruptedException;

    public boolean empty();

    public boolean full();

    public int size();
}
