package ch.hslu.ad.sw10_A2;

public interface IntegerHeap {

    int getMax();

    void insert(int element);

    boolean isFull();

    boolean isEmpty();

    int getParent(int position);

    int getLeftChild(int position);

    int getRightChild(int position);

    void swap(int position1, int position2);

    void reorganize(int position);

    boolean isLeaf(int position);


}
