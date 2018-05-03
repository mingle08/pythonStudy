package algorithm.girlTeacher.graph.bfs;
/**
 * 队列
 * 先进先出
 * @author huxm
 *
 */
public class Queue {

	private final int SIZE = 20;  // 数组最大长度
	private int[] queueArray;  // 队列数组
	private int front;  // 头指针
	private int rear;  // 尾指针
	
	public Queue() {
		this.queueArray = new int[SIZE];
		this.front = 0;
		this.rear = -1;
	}
	/**
	 * 插入：从尾部插入
	 * @param i
	 */
	public void insert(int i) {
		if(rear == SIZE-1) {
			rear = -1;  // 从头开始
		}
		queueArray[++rear] = i;
	}
	
	/**
	 * 删除：从头部删除
	 * @return
	 */
	public int remove() {
		int temp = queueArray[front++];  // 从队列头部删除
		if(front == SIZE) {
			front = 0;
		}
		return temp;
	}
	
	public boolean isEmpty() {
		return (rear+1 == front) || (front+SIZE-1 == rear);
	}
}
