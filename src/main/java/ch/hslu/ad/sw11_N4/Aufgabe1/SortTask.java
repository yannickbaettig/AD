package ch.hslu.ad.sw11_N4.Aufgabe1;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public final class SortTask extends RecursiveAction {
    private final int[] array;
    private final int min;
    private final int max;
    private final int SEQUENTIAL_THRESHOLD = 5;

    public SortTask(int[] array) {
        this (array, 0, array.length);
    }

    private SortTask(int[] array, int min, int max){
        this.array = array;
        this.min = min;
        this.max = max;

    }

    @Override
    protected void compute() {
        if (max-min < SEQUENTIAL_THRESHOLD) { // Sequenzieller Algorithmus
            sortSequentially(min, max);
        } else {
            final int mid= min+(max-min)/2;
            invokeAll(
                new SortTask(array, min, mid),
                new SortTask(array, mid, max));
            merge(min, mid, max);
        } }


    private void sortSequentially(final int min, final int max) {
        Arrays.sort(array, min, max);
    }

    private void merge(final int min, int mid, int max) {
        int[] buf = Arrays.copyOfRange(this.array, min, mid);
        int i = 0;
        int j = min;
        int k = mid;
        while (i < buf.length) {
            if (k == max || buf[i] < this.array[k]) {
                this.array[j] = buf[i];
                i++;
            } else {
                this.array[j] = this.array[k];
                k++;
            }
            j++;
        }
    }
}