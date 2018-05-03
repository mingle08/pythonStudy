package thinkingInJava.chapter12.p709.producerAndcomsumer;
/*
 * 服务员
 */
public class WaitPerson implements Runnable {

	/**
	 * 服务员，属于哪个餐厅
	 */
	private Restaurant restaurant;
	public WaitPerson(Restaurant r) {
		restaurant = r;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					while(restaurant.meal == null) {
						wait();  // for the chef to produce a meal
					}
					System.out.println("WaitPerson got " + restaurant.meal);
					synchronized(restaurant.chef) {
						restaurant.meal = null;
						restaurant.chef.notifyAll(); // ready for another
					}
				}
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
