package algorithm.leetCode;
/*
You have two numbers represented by a linked list, 
where each node contains a single digit. 
The digits are stored in reverse order, 
such that the 1's digit is at the head of the list. 
Write a function that adds the two numbers and returns the sum as a linked list.

Example
Given 7->1->6 + 5->9->2. That is, 617 + 295.

Return 2->1->9. That is 912.

Given 3->1->5 and 5->9->2, return 8->0->8.

Tags Expand 
Cracking The Coding Interview Linked List High Precision
*/
public class AddTwoNumbers {

	public static void main(String[] args) {
		// node1
		ListNode node1 = new ListNode(2);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(3);
		// 打印node1的各节点的值
		showNode(node1);
		System.out.println();
		
		// node2
		ListNode node2 = new ListNode(5);
		node2.next = new ListNode(6);
		node2.next.next = new ListNode(4);
		// 打印node2的各节点的值
		showNode(node2);
		System.out.println();
		
		// 翻转相加
		ListNode node = addTwoNumbers(node1, node2);
		showNode(node);

	}
	
	public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode rst = new ListNode(0);
        ListNode dummy = rst;
        int carrier = 0;
        //while
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                carrier += node1.val;
                node1 = node1.next;
            }
            if (node2 != null) {
                carrier += node2.val;
                node2 = node2.next;
            }
            rst.next = new ListNode(carrier % 10);
            carrier = carrier / 10;
            rst = rst.next;
        }
        //check the carrier
        if (carrier == 1) {
            rst.next = new ListNode(1);
        }
        return dummy.next;
    }

	// 打印一个ListNode各节点的值
	public static void showNode(ListNode node) {
		while(node != null) {
			System.out.print(node.val);
			node = node.next;
		}
	}
}
