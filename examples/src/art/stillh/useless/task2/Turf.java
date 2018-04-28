package art.stillh.useless.task2;

public final class Turf {

	//private static final Logger LOG; //...ist zu initialisieren

	/**
	 * Nein, das Rennen ist nicht gerecht, da ich keine Kontrolle habe in welcher
	 * Reihenfolge die Threads ausgeführt werden -> Single Core
	 */


	public static void main(final String[] args) {
		Synch starterBox = new Latch();
		for (int i = 1; i < 6; i++) {
			new Thread(new RaceHorse(starterBox),"Horse "+i).start();
		}
		System.out.println("wait");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Start...");
		//starterBox.release();
		starterBox.cancel();

	}

}