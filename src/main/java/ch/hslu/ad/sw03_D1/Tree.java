package ch.hslu.ad.sw03_D1;

public interface Tree<T extends Comparable<T>> {

    T search(T data);

    void remove(T data);

    void add(T data);

    void inOrderTraversal(Node node);

    boolean isEmpty();

    void preOrderTraversal(Node node);

    void postOrderTraversal(Node node);
}
