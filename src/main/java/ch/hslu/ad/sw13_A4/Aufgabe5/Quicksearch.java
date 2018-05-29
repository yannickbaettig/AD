package ch.hslu.ad.sw13_A4.Aufgabe5;

public class Quicksearch {

    /**
     * Durchsucht eine Zeichenkette mittels quickSearch.
     *
     * @param a Zeichenkette, die durchsucht wird.
     * @return Index der Fundstelle oder -1, falls Pattern in a nicht gefunden wurde.
     */
    public static int quickSearch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        final int range = 256; // -> ASCII-Range
        final int[] shift = new int[range]; // init shift-array
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        for (int i = 0; i < m; i++) { // overwrite fields according pattern
            shift[p.charAt(i)] = m - i;
        }
        int i = 0; // index to string
        int j = 0; // index to pattern p
        do {
            if (a.charAt(i + j) == p.charAt(j)) { // match
                j++;
            } else { // mismatch
                if ((i + m) < n) { // a.charAt(i1+m) is not outside a
                    i += shift[a.charAt(i + m)]; // jump forward
                    j = 0;
                } else {
                    break; // (mismatch) && (no shift is possible)
                }
            }
        } while ((j < m) && ((i + m) <= n)); // (pattern p not found) && (end of a not reached)

        if (j == m) {
            return i; // pattern found
        } else {
            return -1; // pattern not found
        }

    }


    /**
     * Durchsucht eine Zeichenkette mittels optimal mismatch.
     *
     * @param a Zeichenkette, die durchsucht wird.
     * @return Index der Fundstelle oder -1, falls Pattern in a nicht gefunden wurde.
     */
    public static int optimalMismatch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        final int range = 256; // -> ASCII-Range
        final int[] shift = new int[range]; // init shift-array
        String r = p;
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        for (int i = 0; i < m; i++) { // overwrite fields according pattern
            shift[p.charAt(i)] = m - i;
        }
        int i = 0; // index to string
        int j = 0; // index to pattern p
        do {
            if (a.charAt(i + j) == p.charAt(j)) { // match
                j++;
            } else { // mismatch
                if (j != 0) {
                    char[] rChars = r.toCharArray();
                    char temp = rChars[j];
                    rChars[j] = rChars[j - 1];
                    rChars[j - 1] = temp;
                    r = String.valueOf(rChars);
                }
                if ((i + m) < n) { // a.charAt(i1+m) is not outside a
                    i += shift[a.charAt(i + m)]; // jump forward
                    j = 0;
                } else {
                    break; // (mismatch) && (no shift is possible)
                }
            }
        } while ((j < m) && ((i + m) <= n)); // (pattern p not found) && (end of a not reached)

        if (j == m) {
            return i; // pattern found
        } else {
            return -1; // pattern not found
        }
    }
}
