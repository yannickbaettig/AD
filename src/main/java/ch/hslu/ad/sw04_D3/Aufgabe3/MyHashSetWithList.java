package ch.hslu.ad.sw04_D3.Aufgabe3;

import ch.hslu.ad.sw02_D1.list.MyList;
import ch.hslu.ad.sw04_D3.Set;

import java.util.Arrays;

public class MyHashSetWithList<E> implements Set<E> {
    Node[] hashArray;
    int elements;

    public MyHashSetWithList(int size) {
        this.hashArray = new Node[size];
        this.elements = 0;
    }

    @Override
    public void add(E element) {

        int index = newHashCode(element);
        Node oldNode = hashArray[index];
        Node newNode = new Node(null, element);
        if (oldNode == null){
            hashArray[index] = newNode;
        } else {
            oldNode.setNext(newNode);
        }
        elements ++;
    }

    @Override
    public boolean remove(E element) {
        int index = newHashCode(element);
        Node nodeToRemove = hashArray[index];
        if (nodeToRemove.getData().equals(element)){
            hashArray[index] = nodeToRemove.getNext();
            elements --;
            return true;
        } else {
            return removeRec(element, nodeToRemove);
        }
    }

    private boolean removeRec(E element, Node nodeToRemove) {
        int index = newHashCode(element);
        nodeToRemove = nodeToRemove.getNext();
        if (nodeToRemove == null){
            return false;
        }
        if (nodeToRemove.getData().equals(element)){
            hashArray[index] = nodeToRemove.getNext();
            elements --;
            return true;
        } else {
            return removeRec(element, nodeToRemove);
        }
    }

    @Override
    public boolean search(E element) {
        int index = newHashCode(element);
        Node nodeToRemove = hashArray[index];
        if (nodeToRemove.getData().equals(element)){
            return true;
        } else {
            return searchRec(element, nodeToRemove);
        }
    }

    private boolean searchRec(E element, Node nodeToRemove){
        nodeToRemove = nodeToRemove.getNext();
        if (nodeToRemove == null){
            return false;
        }
        if (nodeToRemove.getData().equals(element)){
            return true;
        } else {
            return searchRec(element, nodeToRemove);
        }
    }


    private int newHashCode(E element) {
        return element.hashCode() % hashArray.length;
    }

    @Override
    public boolean isEmpty() {
        return elements == 0;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        return "MyHashSet{" +
                "hashArray=" + Arrays.toString(hashArray) +
                '}';
    }

    private static class Node<T> {
        private Node<T> next;
        private T data;

        public Node(Node<T> next, T data) {
            this.next = next;
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node<T> next){
            this.next = next;
        }

        @Override
        public String toString() {
            return "data: " + data.toString() + "next: " + next;
        }
    }
}
