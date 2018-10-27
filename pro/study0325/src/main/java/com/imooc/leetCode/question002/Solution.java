package com.imooc.leetCode.question002;

public class Solution {

	public static void main(String[] args) {
		// node1
		ListNode node1 = new ListNode(2);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(3);
		showNode(node1);
		System.out.println();
		
		
		// node1
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(6);
		node2.next.next = new ListNode(4);
		showNode(node2);
		System.out.println();
		
		ListNode node = addTwoNumbers2(node1, node2);
		showNode(node);

	}
	
	public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
		// 头结点
		ListNode rst = new ListNode(0);
		ListNode dummy = rst;
		// 初始进位
		int carrier = 0;
		// while
		while(node1 != null || node2 != null) {
			if(node1 != null) {
				carrier += node1.val;
				node1 = node1.next;
			}
			
			if(node2 != null) {
				carrier += node2.val;
				node2 = node2.next;
			}
			
			rst.next = new ListNode(carrier % 10);
			carrier = carrier / 10;
			rst = rst.next;
		}
		
		// check the carrier
		if(carrier == 1) {
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
	
	
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        int value = l1.val + l2.val;
        ListNode result = new ListNode(value % 10);
        result.next = addTwoNumbers2(l1.next, l2.next);
        if (value >= 10) {
            result.next = addTwoNumbers2(new ListNode(value / 10), result.next);
        }
        return result;
    }

}
