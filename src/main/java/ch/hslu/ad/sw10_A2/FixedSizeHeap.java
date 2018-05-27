package ch.hslu.ad.sw10_A2;

import java.util.Arrays;
import java.util.Collections;

public class FixedSizeHeap implements IntegerHeap {
    private int[] heap;
    private int size;

    public FixedSizeHeap(int size) {
        this.heap = new int[size];
        this.size = 0;
    }

    @Override
    public int getMax() {
        int element = 0;
        if (!isEmpty()){
            size--;
            element = heap[0];
            heap[0] = heap[size];
            heap[size] = 0;
            reorganize(0);
        }
        return element;
    }

    @Override
    public void insert(int element) {
        if (!isFull()){
            heap[size] = element;
            int currentItem = size;
            while (heap[currentItem] > heap[getParent(currentItem)]){
                swap(currentItem,getParent(currentItem));
                currentItem = getParent(currentItem);
            }
            size++;
        }
    }

    @Override
    public boolean isFull() {
        return size == heap.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getParent(int position) {
        return (position-1)/2;
    }

    @Override
    public int getLeftChild(int position) {
        return (2*position)+1;
    }

    @Override
    public int getRightChild(int position) {
        return 2*(position+1);
    }

    @Override
    public void swap(int position1, int position2) {
        int tmp = heap[position1];
        heap[position1] = heap[position2];
        heap[position2] = tmp;
    }

    @Override
    public void reorganize(int position) {
        while (!isLeaf(position)) {
            int left  = getLeftChild(position);
            int right = getRightChild(position);
            if (heap[position] < heap[left] || heap[position] < heap[right]){
                if (heap[left] > heap[right]){
                    swap(position, left);
                    position = left;
                } else {
                    swap(position, right);
                    position = right;
                }
            } else
                break;
        }
    }
    @Override
    public boolean isLeaf(int position) {
        return getLeftChild(position) >= this.size;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(int i=0; i<= size/2; i++){
            output.append("\n");
            output.append("Parent: "+ heap[i]);
            output.append(" LeftChild: "+heap[getLeftChild(i)] +" RightChild: "+ heap[getRightChild(i)]);
        }
        return output.toString();
    }

    public int[] getHeap() {
        return heap;
    }

    public int getSize() {
        return size;
    }
}
