package ch.hslu.ad.sw03_D2.Hashcode;

import java.util.Objects;

public class Node<K extends Comparable, V> {
    V data;
    K key;
    Node<K,V> leftChildNode;
    Node<K,V> rightChildNode;

    public Node(K key,V data) {
        this(key, data, null, null  );
    }

    public Node(K key, V data, Node leftChildNode, Node rightChildNode) {
        this.key = key;
        this.data = data;
        this.leftChildNode = leftChildNode;
        this.rightChildNode = rightChildNode;
    }

    public V getData() {
        return data;
    }

    public Node<K,V> getLeftChildNode() {
        return leftChildNode;
    }

    public Node<K,V> getRightChildNode() {
        return rightChildNode;
    }

    public void setData(V data) {
        this.data = data;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setLeftChildNode(Node<K, V> leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public void setRightChildNode(Node<K, V> rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                ", key=" + key +
                "data=" + data +
                ", leftChildNode=" + leftChildNode +
                ", rightChildNode=" + rightChildNode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
