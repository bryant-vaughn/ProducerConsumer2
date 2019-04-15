public class Producer extends Thread {

	private final BoundedBuffer buffer;

	// Create a Producer
	public Producer(BoundedBuffer b) {
		buffer = b;
	}

	// What to run when the thread is started
	public void run() {
		try {
			for(int index = 0; index < 100; index++) {
				buffer.put(index);
				sleep(100);
			}
		} catch(InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
	}
}