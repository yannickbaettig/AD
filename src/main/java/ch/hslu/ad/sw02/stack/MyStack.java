package ch.hslu.ad.sw02.stack;

import java.lang.reflect.Array;

public class MyStack<T> implements Stack<T>{
    private int top;
    private final int size;
    private T[] stackArray;

    public MyStack(int size) {
        this.size = size;
        stackArray = (T[])new Object[size];
        top = -1;
    }


    @Override
    public void push(T data) {
        if (top == size - 1){
            throw new IndexOutOfBoundsException();
        } else {
            top ++;
            stackArray[top] = data;
        }
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        } else {
            T data = stackArray[top];
            top --;
            return data;
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public int getTop() {
        return top;
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i <= size -1 ; i++){
            string += "\n" + stackArray[i];
        }
        return string;
    }
}
