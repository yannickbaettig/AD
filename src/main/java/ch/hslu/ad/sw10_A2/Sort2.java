package ch.hslu.ad.sw10_A2;

import java.util.Random;

public class Sort2<T extends Comparable<T>>{

    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param a Zeichen‐Array
     * @param firstIndex Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private final void exchange(final char[] a, final int firstIndex, final int secondIndex) {
        char tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;

    }

    public char[] randomChars(final int length){
        char[] randomChars = new char[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            randomChars[i] = (char)(r.nextInt(26) + 'a');
        }
        return randomChars;
    }

    public void quickSort(final char[] a){
        quickSort(a,0, a.length-1);
    }

    private final void quickSort(final char[] a, final int left, final int right) {
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        char t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;

        do {
            while (a[up] < t) { // suche grösseres (>=) Element von links an
                up++;
            }
            while ((a[down] >= t) && (down > up)) { // suche echt kleineres(<) Element von rechts an
                down--;
            }
            if (down > up) {  // solange keine Überschneidung
                exchange(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beenden
            }
        } while (!allChecked);
        exchange(a, up, right);
        if (left < (up - 1)) quickSort(a, left, (up - 1)); // linke Hälfte
        if ((up + 1) < right) quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt

}



    public void quickInsertionSort(final char[] a) {
        quickInsertionSort(a,0, a.length-1);
    }

    private void quickInsertionSort(final char[] a, final int left, final int right) {
        int m = 25;
        if (right - left <= m) {
            insertionSort(a, left, right);
        } else {
            int up = left; // linke Grenze
            int down = right - 1; // rechte Grenze (ohne Trennelement)
            char t = a[right]; // rechtes Element als Trennelement
            boolean allChecked = false;

            do {
                while (a[up] < t) { // suche grösseres (>=) Element von links an
                    up++;
                }
                while ((a[down] >= t) && (down > up)) { // suche echt kleineres(<) Element von rechts an
                    down--;
                }
                if (down > up) {  // solange keine Überschneidung
                    exchange(a, up, down);
                    up++;
                    down--; // linke und rechte Grenze verschieben
                } else {
                    allChecked = true; // Austauschen beenden
                }
            } while (!allChecked);
            exchange(a, up, right);
            if (left < (up - 1)) quickInsertionSort(a, left, (up - 1)); // linke Hälfte
            if ((up + 1) < right) quickInsertionSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt
        }
    }

    private void insertionSort(char[] array, int left, int right){
        char element;
        int j;
        for (int i = left; i < right; i++){
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