package ch.hslu.ad.sw04_D3;

import java.util.Arrays;
import java.util.Objects;

public class MyHashSet<E> implements Set<E> {
    E[] hashArray;
    int elements;

    public MyHashSet(int size) {
        this.hashArray = (E[])new Object[size];
        this.elements = 0;
    }

    @Override
    public void add(E element) {
        if (size() == hashArray.length) {
            throw new IndexOutOfBoundsException("Array is Full");
        }
        int index = newHashCode(element);
        E oldElement = hashArray[index];
        if (oldElement == null){
            hashArray[index] = element;
            elements ++;
        } else {
            addRec(element, index);
        }
    }

    private void addRec(E element, int index) {
        int newIndex = (index + 1) % hashArray.length;
        E oldElement = hashArray[newIndex];
        if (oldElement == null){
            hashArray[newIndex] = element;
            elements ++;
        } else {
            addRec(element, newIndex);
        }
    }

    @Override
    public boolean remove(E element) {
        int index = newHashCode(element);
        E elementToRemove = hashArray[index];
        if (elementToRemove.equals(element)){
            hashArray[index] = null;
            elements --;
            return true;
        } else {
            return removeRec(element, index);
        }
    }

    private boolean removeRec(E element, int index) {
        int newIndex = (index + 1) % hashArray.length;
        E elementToRemove = hashArray[newIndex];
        if (newIndex == newHashCode(element) || elementToRemove == null){
            return false;
        }
        if (elementToRemove.equals(element)){
            hashArray[newIndex] = null;
            elements --;
            return true;
        } else {
            return removeRec(element, newIndex);
        }
    }

    @Override
    public boolean search(E element) {
        int index = newHashCode(element);
        E elementToReturn = hashArray[index];
        if(element.equals(elementToReturn)) {
            return true;
        } else {
           return searchRec(element, index);
        }
    }

    private boolean searchRec(E element, int index){
        int newIndex = (index + 1) % hashArray.length;
        E elementToReturn = hashArray[newIndex];
        if (newIndex == newHashCode(element) || elementToReturn == null){
            return false;
        }
        if(element.equals(elementToReturn)) {
            return true;
        } else {
           return searchRec(element, newIndex);
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
}
