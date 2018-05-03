package thinkingInJava.chapter12.p712.lock;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable {

	private Car car;
	public WaxOn(Car c) {
		car = c;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				System.out.println("Wax On! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (Exception e) {
			System.out.println("Exiting via interrupt.");
		}
		System.out.println("Ending Wax On task.");
	}

}
