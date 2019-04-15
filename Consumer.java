import java.util.Random;


public class Consumer extends Thread {
	
	private final BoundedBuffer buffer;
	Random generator;

	// Constructs a consumer of items from a bounded buffer
	public Consumer(BoundedBuffer b) {
		buffer = b;					// The bounded buffer
		generator = new Random();	// Used to generate a random wait time
	}

	// What to run when the thread is started
	public void run() {
		try {
			while(true) {
				int n = buffer.get();
				int waitTime = 100 + generator.nextInt(200);
				sleep(waitTime);
				System.out.println(n);
			}
		} catch(InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
	}
}