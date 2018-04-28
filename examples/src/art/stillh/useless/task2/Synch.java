package art.stillh.useless.task2;

/**
 * Schnittstelle für die Zutrittsverwaltung geschützter Bereiche.
 */
public interface Synch {
	/**
	 * Eintritt in einen geschützten Bereich erlangen,
	 * falls kein Zutritt möglich ist warten.
	 * @throws InterruptedException wenn das Warten unterbrochen wird.
	 */
	void acquire() throws InterruptedException;
	/**
	 * Freigabe des geschützten Bereiches.
	 */
	void release();

	void cancel();

}