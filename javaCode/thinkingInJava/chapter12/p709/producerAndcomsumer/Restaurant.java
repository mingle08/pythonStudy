package thinkingInJava.chapter12.p709.producerAndcomsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 餐厅：
 * 食物，服务员，厨师
 * @author huxm
 *
 */
public class Restaurant {

	Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);
	public Restaurant() {
		exec.execute(chef);
		exec.execute(waitPerson);
	}
	
	public static void main(String[] args) {
		new Restaurant();
	}
}
