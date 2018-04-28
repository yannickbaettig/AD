package art.stillh.useless.task3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Supplier;

public class BoundedBuffer<T> {

	private final Object lock = new Object();

	private int max;
	private Deque<Object> buffer;

	public BoundedBuffer(int size) {
		this.max = size;
		this.buffer = new ArrayDeque<>(size);
	}

	@SuppressWarnings("unchecked")
	public T front() throws InterruptedException {
		return this.front(-1);
	}

	@SuppressWarnings("unchecked")
	public T front(int timeout) throws InterruptedException {
		return (T) this.action(
				() -> this.buffer.isEmpty(),
				() -> this.buffer.getFirst(),
				timeout
		);
	}

	@SuppressWarnings("unchecked")
	public T back() throws InterruptedException {
		return this.back(-1);
	}

	@SuppressWarnings("unchecked")
	public T back(int timeout) throws InterruptedException {
		return (T) this.action(
				() -> this.buffer.isEmpty(),
				() -> this.buffer.getLast(),
				timeout
		);
	}

	@SuppressWarnings("unchecked")
	public T pop(int timeout) throws InterruptedException {
		return (T) this.action(
				() -> this.buffer.isEmpty(),
				() -> this.buffer.pop(),
				timeout
		);
	}

	public boolean offer(T obj) throws InterruptedException {
		return this.offer(obj, -1);
	}

	public boolean offer(T obj, int timeout) throws InterruptedException {
		return (Boolean) this.action(
				() -> this.buffer.size() == this.max,
				() -> this.buffer.offerLast(obj),
				timeout
		);
	}

	public boolean push(T obj, int timeout) throws InterruptedException {
		return (Boolean) this.action(
				() -> this.buffer.size() == this.max,
				() -> this.buffer.offerFirst(obj),
				timeout
		);
	}

	public int size() {
		synchronized (this.lock) {
			return this.buffer.size();
		}
	}

	public boolean isEmpty() {
		synchronized (this.lock) {
			return this.buffer.isEmpty();
		}
	}

	public boolean isFull() {
		synchronized (this.lock) {
			return this.buffer.size() == this.max;
		}
	}

	private Object action(Supplier<Boolean> antiCondition, Supplier<Object> action, int timeout) throws InterruptedException {
		synchronized (this.lock) {

			if(timeout < 0) {
				while (antiCondition.get()) this.lock.wait();
			} else {
				if (antiCondition.get()) {
					this.lock.wait(timeout);
					if(antiCondition.get()) throw new InterruptedException();
				}
			}

			Object obj = action.get();
			this.lock.notifyAll();
			return obj;
		}
	}

}
