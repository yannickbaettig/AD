package ch.hslu.ad.sw09_A1;

public class Sort<T extends Comparable<T>>{

    public void insertionSort(T[] array){
        T element;
        int j;
        for (int i = 1; i < array.length; i++){
            element = array[i];
            j = i;
            while ((j > 0) && array[j-1].compareTo(element) > 0 ){
                array[j] = array[j-1];
                j--;
            }
            array[j] = element;
        }
    }

    public void selectionSort(T[] array){
        int min;
        for (int i = 0; i < array.length-1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min].compareTo(array[j]) > 0){
                    min = j;
                }
            }
            T temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    public void bubbleSort(T[] array) {
        int max;
        for (int i = array.length; i >= 0; i--) {
            for (int j = 1; j < i; j++ ) {
                max = j-1;
                if (array[max].compareTo(array[j]) > 0) {
                    T temp = array[max];
                    array[max] = array[j];
                    array[j] = temp;
                }
            }
        }

    }

}
