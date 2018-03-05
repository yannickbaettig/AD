package ch.hslu.ad.sw02.stack;

public interface Stack<T> {

    public void push(T data);

    public T pop();

    public boolean isEmpty();
}
