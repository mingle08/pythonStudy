package thinkingInJava.chapter12.blockingQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class TestBlockingQueues {

	static void getKey() {
		try {
			// compensate for windows/Linux difference in the length of the result
			// produced by the Enter key:
			new BufferedReader(new InputStreamReader(System.in)).readLine();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	static void getKey(String message) {
		System.out.println(message);
		getKey();
	}
	
	static void test(String msg, BlockingQueue<LiftOff> queue) {
		System.out.println(msg);
		LiftOffRunner runner = new LiftOffRunner(queue);
		Thread t = new Thread(runner);
		t.start();
		for (int i = 0; i < 5; i++) {
			runner.add(new LiftOff(5));
			
		}
		getKey("Press 'Enter' (" + msg + ")");
		t.interrupt();
		System.out.println("Finished " + msg + " test");
	}
	
	public static void main(String[] args) {
		test("LinkedBlockingQueue", // Unlimited size
				new LinkedBlockingQueue<LiftOff>());
		test("ArrayBlockingQueue", // Fixed size
				new ArrayBlockingQueue<LiftOff>(3));
		test("SynchronousQueue", // Size of 1
				new SynchronousQueue<LiftOff>());
	}
}
