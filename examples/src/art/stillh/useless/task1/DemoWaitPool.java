package art.stillh.useless.task1;

public class DemoWaitPool {

	/**
	 * 1: IllegalMonitorStateException ->
	 *    - wait on "lock" object
	 *    - notify in synchronized block
	 *
	 * 2: no errors
	 *
	 * 3: sync block in MyTask prevents parallel execution
	 *    therefore never stops waiting
	 *
	 */

	private static final Object lock = new Object();

	public static void main(final String args[]) throws InterruptedException {

		synchronized (lock) {

			final MyTask waiter = new MyTask(lock);
			new Thread(waiter).start();
			Thread.sleep(1000);

			lock.notify();
		}

	}

}
