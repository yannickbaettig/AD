package art.stillh.useless.task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BoundedBufferTest {

	@Test
	public void testGetNull() {
		BoundedBuffer<Object> buffer = new BoundedBuffer<>(1);
		assertThrows(InterruptedException.class, () -> buffer.pop(1));
	}

	@Test
	public void testGetObj() throws InterruptedException {
		BoundedBuffer<Object> buffer = new BoundedBuffer<>(1);
		Object k = new Object();
		buffer.offer(k);
		assertEquals(buffer.pop(1), k );
	}
}
