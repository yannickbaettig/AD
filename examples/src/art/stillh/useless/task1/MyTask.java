package art.stillh.useless.task1;

public final class MyTask implements Runnable {

	//private static final Logger LOG = LogManager.getLogger(ch.hslu.ad.exercise.MyTask.class);

	private final Object lock;
	public MyTask(final Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		System.out.println("warten...");
		synchronized (lock) {
			try {
				lock.wait();
			} catch (InterruptedException ex) {
				return;
			}
		}
		System.out.println("...aufgewacht");
	}
}