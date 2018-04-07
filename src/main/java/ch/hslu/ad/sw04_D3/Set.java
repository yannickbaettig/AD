package ch.hslu.ad.sw04_D3;

public interface Set<E> {

    void add(E element);

    boolean remove(E element);

    boolean search(E element);

    boolean isEmpty();

    int size();
}
