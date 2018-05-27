package ch.hslu.ad.sw11_N4.Aufgabe2;

import java.util.concurrent.RecursiveAction;

public class ParallelQuickSort extends RecursiveAction {
    private final int[] array;
    private final int left;
    private final int right;
    private final int SEQUENTIAL_THRESHOLD = 5;

    public ParallelQuickSort(int[] array){
        this (array,0,array.length-1);
    }

    private ParallelQuickSort(int[] array, int left, int right){
        this.array = array;
        this.left = left;
        this.right = right;
    }


    @Override
    protected void compute() {
        if (right - left < SEQUENTIAL_THRESHOLD) {
            insertionSort(array, left, right);
        } else
        if (left < right){
            int pivotIndex = partition();
            invokeAll( new ParallelQuickSort(array, left, pivotIndex-1),
                        new ParallelQuickSort(array, pivotIndex+1, right)
            );
        }
    }


    private int partition(){
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                exchange(array,i, j);

            }
        }
        exchange(array,i + 1, right);
        return i + 1;
    }

    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param a Zeichen‐Array
     * @param firstIndex Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private void exchange(final int[] a, final int firstIndex, final int secondIndex) {
        int tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    private void insertionSort(int[] array, int min, int max){
        int element;
        int j;
        for (int i = min; i <= max; i++){
            element = array[i];
            j = i;
            while ((j > 0) && array[j-1] > element ){
                array[j] = array[j-1];
                j--;
            }
            array[j] = element;
        }
    }

}
