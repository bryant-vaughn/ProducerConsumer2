/**
 * BoundedBuffer.java
 *
 * This program implements the bounded buffer with semaphores.
 * Note that the use of count only serves to output whether
 * the buffer is empty or full.
 *
 * Bryant Vaughn
 * CS 3600 Operating Systems
 * Dr. Iliya Georgiev
 * MSU Denver
 */

public class BoundedBuffer {
	protected int numSlots;
	private int[] buffer;
	private int takeOut = 0, putIn = 0;
	private int count = 0;

	public BoundedBuffer(int numSlots) {
		if(numSlots <= 0) {
			throw new IllegalArgumentException("numSlots <= 0");
		}

		this.numSlots = numSlots;
		buffer = new int[numSlots];
	}

	// Put an item in the bounded buffer. Block if full.
	public synchronized void put(int value) throws InterruptedException {
		while(count == numSlots)
			wait();

		buffer[putIn] = value;
		putIn = (putIn + 1) % numSLots;
		count++;
		notifyAll();
	}

	// Remove an item from a bounded buffer. Block if empty
	public synchronized int get() throws InterruptedException {
		while(count == 0)
			wait();

		int value = buffer[takeOut];
		takeOut = (takeOut + 1) % numSlots;
		count--;
		notifyAll();
		return value;
	}
}