package art.stillh.useless.task2;

import java.util.ArrayList;

public class Latch implements Synch {

	private final static long TIMEOUT = 10_000;

	private ArrayList<Thread> threads = new ArrayList<>();
	private final Object lock = new Object();

	@Override
	public void acquire() throws InterruptedException {
		synchronized (lock) {
			threads.add(Thread.currentThread());
			lock.wait(TIMEOUT);
		}
	}

	@Override
	public void release() {
		synchronized (lock) {
			lock.notifyAll();
		}
	}

	@Override
	public void cancel() {
		synchronized (lock) {
			threads.forEach(Thread::interrupt);
		}
	}

}
