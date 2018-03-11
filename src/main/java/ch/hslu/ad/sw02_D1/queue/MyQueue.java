package ch.hslu.ad.sw02_D1.queue;

import java.util.Arrays;

public class MyQueue<T> implements Queue<T> {
    private int head;
    private int tail;
    private final int size;
    private T[] queueArray;

    public MyQueue(int size) {
        if (size <= 0 ){
            throw new IllegalArgumentException("not <= 0");
        }
        this.head = -1;
        this.tail = -1;
        this.size = size;
        this.queueArray = (T[])new Object[size];
    }

    @Override
    public void enqueue(T data) {
        if (isFull()){
            throw new IllegalStateException("is Full");
        } else if (isEmpty()){
            head ++;
            tail ++;
            queueArray[tail] = data;
        } else {
            tail = (tail + 1) % size;
            queueArray[tail] = data;
        }
    }


    @Override
    public T dequeue() {
        T data;
        if (isEmpty()){
            throw new IllegalStateException("Is Empty");
        } else if (head == tail){
            data = queueArray[head];
            queueArray[head] = null;
            head = -1;
            tail = -1;
        } else {
            data = queueArray[head];
            queueArray[head] = null;
            head = (head + 1) % size;
        }
        return data;
    }

    @Override
    public boolean isEmpty() {
        return (head == -1 && tail == -1);
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                ", queueArray=" + Arrays.toString(queueArray) +
                '}';
    }
}
