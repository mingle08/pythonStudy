package algorithm.girlTeacher.doublyLinkedList;
/**
 * 双端队列
 * @author huxm
 *
 */
public class DoublyLinkedList {

	private Node first;
	private Node last;
	public DoublyLinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(long dd) {
		Node node = new Node(dd);
		if(isEmpty()) {// 如果是空，新加的节点是第一个节点，也是最后一个节点
			last = node;
		}else {// 原来不为空，则第一个的前一个，就是新节点。而last节点，还是原来的last节点，没有变化
			first.previous = node;
		}
		node.next = first;// 新节点的下一个节点，是原来的第一个节点
		first = node;  // 新的第一个节点，就是新插入的节点
		
	}
	
	public void insertLast(long dd) {
		Node node = new Node(dd);
		if(isEmpty()) {// 如果是空，第一个节点，是新节点
			first = node;
		}else {// 因为是从链表尾部插入，所以影响的是last节点
			last.next = node;
			node.previous = last;  // 原来的last节点，变成新节点的前节点
		}
		
		last = node;  // 新的last节点，是新插入的节点
		
	}
	/**
	 * 从链表头部删除
	 * @return
	 */
	public Node deleteFirst() {
		Node temp = first;  // 头节点，是要删除的节点
		if(first.next == null) {// 如果链表只有一个节点
			last = null;  // 删除之后，last指针就指向空
		}else {
			first.next.previous = null;  // 如果不止一个节点，头节点的后节点的前节点就为空，而last指针不变
		}
		first = first.next;  // 原来的第二节点，就成了新的头节点
		return temp;
		
	}
	/**
	 * 从后面开始删除
	 * @return
	 */
	public Node deleteLast() {
		Node temp = last;
		if(first.next == null)  // 如果只有一个节点
			first = null;   // 影响头指针的指向，指为空
		else
			last.previous.next = null;  // 如果不止一个节点，则头指针不受影响，last指针的前节点的后节点被删除
		
		last = last.previous;  // last指针要改变，指向前节点
		return temp;
	}
	
	/**
	 * 在指定位置的后面插入
	 * @param key     在key后面插入
	 * @param dd      插入的值为dd
	 * @return
	 */
	public boolean insertAfter(long key, long dd) {
		Node current = first;   // 将头节点设为当前节点
		while(current.dData != key) {  // 只要当前节点的值与key不相等，就往后面找
			current = current.next;
			if(current == null)  // 如果当前节点是最后一个节点，都没有找到，就说明此链表中没有值为key的节点
				return false;
		}
		// 能走到这一步，说明找到值为key的节点
		Node newNode = new Node(dd);
		if(current == last) {  // 如果目标节点是尾节点，那么新节点就是新的尾节点
			newNode.next = null;
			last = newNode;
		}else {// 如果目标节点是中间的某节点
			/**
			 * 当前节点的后节点与新节点的关系
			 */
			newNode.next = current.next;   // 当前节点的后节点，就是新节点的后节点                  current      newNode       current.next
			current.next.previous = newNode;  // 新节点是当前节点的后节点的前节点
		}
		
		/**
		 * 当前节点与新节点的关系
		 */
		newNode.previous = current;  // 当前节点，是新节点的前节点
		current.next = newNode;  // 新节点，是当前节点的后节点
		return true;
	}
	
	public Node deleteKey(long key) {
		Node current = first;    // 把头节点设为当前节点
		while(current.dData != key) {  // 如果当前节点的值不等于key，就往后循环找
			current = current.next;
			if(current == null) 
				return null;
		}
		
		/*if(current == first) {
			// 双端队列，要维护头指针
			first = current.next;
		}else {
			// 当前节点（将被删除）之前的节点的后节点，就是当前节点（将被删除）的后节点
			current.previous.next = current.next;
		}
		
		if(current == last)
			// 双端队列，要维护last指针
			last = current.previous;
		else
			// 当前节点（将被删除）后面的节点的前节点，就是当前节点（将被删除）的前节点
			current.next.previous = current.previous;*/
		
		if(current == first) {
			// 双端队列，要维护头指针
			first = current.next;
		}else if(current == last){
			// 双端队列，要维护last指针
			last = current.previous;
		}else {
			// 维护前节点：  当前节点（将被删除）后面的节点的前节点，就是当前节点（将被删除）的前节点
			current.next.previous = current.previous;
			// 维护后节点： 当前节点（将被删除）之前的节点的后节点，就是当前节点（将被删除）的后节点
			current.previous.next = current.next;
		}
			
		return current;
	}
	/**
	 * 从前向后显示
	 */
	public void displayForward() {
		System.out.print("List (first ---> last): ");
		Node current = first;
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
	
	/**
	 * 从后往前显示
	 */
	public void displayBackward() {
		System.out.print("List (last ---> first): ");
		Node current = last;
		while(current != null) {
			current.displayNode();
			current = current.previous;
		}
		System.out.println();
	}
}
