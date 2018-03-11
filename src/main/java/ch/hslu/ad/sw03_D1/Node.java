package ch.hslu.ad.sw03_D1;

public class Node<T extends Comparable<T>> {
    T data;
    Node<T> leftChildNode;
    Node<T> rightChildNode;

    public Node(T data) {
        this(data, null, null  );
    }

    public Node(T data, Node leftChildNode, Node rightChildNode) {
        this.data = data;
        this.leftChildNode = leftChildNode;
        this.rightChildNode = rightChildNode;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeftChildNode() {
        return leftChildNode;
    }

    public Node<T> getRightChildNode() {
        return rightChildNode;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeftChildNode(Node leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public void setRightChildNode(Node rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", leftChildNode=" + leftChildNode +
                ", rightChildNode=" + rightChildNode +
                '}';
    }
}
