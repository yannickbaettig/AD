package ch.hslu.ad.sw02_D1.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<T> implements Iterable<T>{
    private Node head;
    private Node tail;
    private int size;

    public MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data);

        if (isEmpty()){
            head = newNode;
            tail = newNode;
        } else {
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        size ++;
    }

    public void addAllFirst(T... datas) {
        for (T data : datas) {
            addFirst(data);
        }
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<T>(data);

        if (isEmpty()){
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size ++;
    }

    public Node<T> removeFirst() {
        if (isEmpty()){
            throw new NoSuchElementException();
        } else {
            Node<T> firstNode = head;
            Node<T> newFirstNode = firstNode.getNext();
            newFirstNode.previous = null;
            head = newFirstNode;
            size --;
            return firstNode;
        }

    }

 /*   public T getElement(T data){
        Iterator<T> it = iterator();
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        while (it.hasNext()){
            T node = it.next();
            if ( node.equals(data)){
                return node;
            }
        }
        return null;
    }*/

    public Node<T> getElement(T data){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Node currentNode = head;
        while (currentNode != null){
            if (currentNode.data.equals(data)){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        throw new NoSuchElementException();
    }

    public void removeElement(T data) {
        Node<T> node = getElement(data);
        Node<T> previousNode = node.previous;
        Node<T> nextNode = node.next;

        previousNode.next = nextNode;
        nextNode.previous = previousNode;
        node.previous = null;
        node.next = null;

        size--;

    }

    public int getSize() {
        return size;
    }


    @Override
    public String toString() {
        Node node = head;
        StringBuilder string = new StringBuilder();
        while (node != null) {
            string.append(" ").append(node.toString()).append(System.lineSeparator());
            node = node.getNext();
        }
        string.append(" size: ").append(size);
        return string.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>();
    }

    public class ListIterator<T> implements Iterator<T> {
        private Node<T> currentNode;
        private Node<T> previousNode;

        public ListIterator() {
            this.currentNode = head;
            this.previousNode = null;
        }

        @Override
        public boolean hasNext() {
            if (currentNode != null) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public T next() {
            if (!hasNext()){
                return null;
            }
            T data = currentNode.getData();
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            return data;
        }

        @Override
        public void remove(){
            if (currentNode != null) {
                if (previousNode != null) {
                    previousNode.next = currentNode.next;
                } else {
                    head = currentNode.next;
                }
            }
        }

    }

    private static class Node<T> {
        private Node<T> next;
        private Node<T> previous;
        private T data;

        public Node(T data) {
            this(null,null,data);
        }

        public Node(Node<T> next, Node<T> previous, T data) {
            this.next = next;
            this.previous = previous;
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

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return "data: " + data.toString();
        }
    }
}
