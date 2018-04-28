package art.stillh.useless.task2;

import java.util.Random;

/**
 * Ein Rennpferd, das durch ein Startsignal losläuft.
 * Nach einer zufälligen Zeit kommt es im Ziel an.
 */
public final class RaceHorse implements Runnable {

	//private static final Logger LOG; //...ist zu initialisieren

	private final Synch startSignal;
	private volatile Thread runThread;
	private final Random random;
	/**
	 * Erzeugt ein Rennpferd, das in die Starterbox eintritt.
	 * @param startSignal Starterbox.
	 */
	public RaceHorse(Synch startSignal) {
		this.startSignal = startSignal;
		this.random = new Random();
	}

	//...

	@Override
	public void run() {
		runThread = Thread.currentThread();
		System.out.println("Rennpferd " + runThread.getName() + " geht in die Box.");
		try {
			startSignal.acquire();
			System.out.println("Rennpferd " + runThread.getName() + " läuft los...");
			Thread.sleep(random.nextInt(3000));
			System.out.println("Rennpferd " + runThread.getName() + " ist im Ziel.");
		} catch (InterruptedException ex) {
			//ex.printStackTrace();
			System.out.println("Race has been canceled");
		}

	}

}