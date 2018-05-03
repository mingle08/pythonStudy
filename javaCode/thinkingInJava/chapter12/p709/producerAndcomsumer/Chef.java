package thinkingInJava.chapter12.p709.producerAndcomsumer;

import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {

	/**
	 * 厨师，属于哪个餐厅
	 */
	private Restaurant restaurant;
	private int count = 0;
	public Chef(Restaurant r) {
		restaurant = r;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					while(restaurant.meal != null)
						wait();  // ... for the meal to be taken
				}
				if(++count == 10) {
					System.out.println("Out of food, closing.");
					restaurant.exec.shutdownNow();
				}
				
				System.out.println("Order up!");
				synchronized(restaurant.waitPerson) {
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.notifyAll();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (Exception e) {
			System.out.println("Chef interrupted.");
		}

	}

}
