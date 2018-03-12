package ch.hslu.ad.sw03_D1.Hashcode;

import ch.hslu.ad.sw03_D1.Hashcode.Node;

public interface Tree<K extends Comparable,V> {

    V search(K key);

    void remove(K key);

    void add(K key, V data);

    void inOrderTraversal(Node node);

    boolean isEmpty();

    void preOrderTraversal(Node node);

    void postOrderTraversal(Node node);
}
