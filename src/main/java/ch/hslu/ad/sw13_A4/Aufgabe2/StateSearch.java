package ch.hslu.ad.sw13_A4.Aufgabe2;

public class StateSearch {

    /**
     * Durchsucht eine Zeichenkette mittels optimiertem Suchautomaten.
     *
     * @param s Zeichenkette, die durchsucht wird.
     * @return Index der Fundstelle oder ‐1, falls Pattern in a nicht gefunden wurde.
     */
    public static int stateSearch(final String s) {
        int i = 0; //indextostringa
        String state = ""; // means "nothing found"
        final int notFound = -1;
        do {
            switch (state) {
                case "":
                    if (s.charAt(i) == 'A') {
                        state = "A";
                    }
                    break;
                case "A":
                    if (s.charAt(i) == 'N') {
                        state = "AN";
                    } else if (s.charAt(i) != 'A') {
                        state = "";
                    }
                    break;
                case "AN":
                    if (s.charAt(i) == 'A') {
                        state = "ANA";
                    } else {
                        state = "";
                    }
                    break;
                case "ANA":
                    if (s.charAt(i) == 'N') {
                        state = "ANAN";
                    } else if (s.charAt(i) == 'A'){
                        state = "A";
                    } else {
                        state = "";
                    }
                    break;
                case "ANAN":
                    if (s.charAt(i) == 'A') {
                        state = "ANANA";
                    } else {
                        state = "";
                    }
                    break;
                case "ANANA":
                    if (s.charAt(i) == 'S') {
                        state = "ANANAS";
                    } else if (s.charAt(i) == 'N'){
                        state = "ANAN";
                    } else {
                        state = "";
                    }
                    break;
            }
            i++;
        } while ((!state.equals("ANANAS")) && (i < s.length()));

        if (state.equals("ANANAS")) {
            return (i-state.length());
        }
        return notFound;
    }
}