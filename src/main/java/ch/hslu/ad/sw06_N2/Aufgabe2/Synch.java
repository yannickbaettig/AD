package ch.hslu.ad.sw06_N2.Aufgabe2;
/**
 * Schnittstelle für die Zutrittsverwaltung geschützter Bereiche.
 */
public interface Synch {
    /**
     * Eintritt in einen geschützten Bereich erlangen,
     * falls kein Zutritt möglich ist warten.
     * @throws InterruptedException wenn das Warten unterbrochen wird.
     */
    public void acquire() throws InterruptedException;
    /**
     * Freigabe des geschützten Bereiches.
     */
    public void release();

    public void cancel();
}
