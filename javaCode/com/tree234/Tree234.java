package com.tree234;

public class Tree234 {

	private Node root = new Node();
	public int find(long key) {
		Node curNode = root;
		int childNumber;
		while(true) {
			if((childNumber=curNode.findItem(key)) != -1) // 找到了
				return childNumber;
			else if(curNode.isLeaf()) // 没有找到
				return -1;
			else
				curNode = getNextChild(curNode, key);
		}
	}
	
	private Node getNextChild(Node node, long val) {
		int j;
		int numItems = node.getNumItems();
		for(j = 0; j < numItems; j++) {
			if(val < node.getItem(j).dData) {
				return node.getChild(j);
			}
		}
		return node.getChild(j); // 取最后一个
	}
	
	public void insert(long dValue) {
		Node curNode = root;
		DataItem tempItem = new DataItem(dValue);
		while(true) {
			if(curNode.isFull()) {
				split(curNode); // 拆分节点
				curNode = curNode.getParent();
				curNode = getNextChild(curNode, dValue);
			}else if(curNode.isLeaf()){ // 未满，且是叶子节点
				break;
			}else {
				curNode = getNextChild(curNode, dValue);
			}
		}
		curNode.insertItem(tempItem);
	}
	
	public void split(Node node) { // 拆分节点
		DataItem itemB, itemC;
		Node parent, child2, child3;
		int itemIndex;
		itemC = node.removeItem(); // 最大的数据项
		itemB = node.removeItem(); // 中间的数据项
		child2 = node.disconnectChild(2);
		child3 = node.disconnectChild(3);
		Node newRight = new Node();
		if(node == root) { // 如果是根
			root = new Node();
			parent = root;
			root.connectChild(0, node);
		}else {
			parent = node.getParent();
			
		}
		
		itemIndex = parent.insertItem(itemB);
		int n = parent.getNumItems();
		for(int j = n - 1; j > itemIndex; j--) {
			Node temp = parent.disconnectChild(j);
			parent.connectChild(j + 1, temp);
		}
		parent.connectChild(itemIndex + 1, newRight);
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}
	
	public void displayTree() {
		recDisplayTree(root, 0, 0);
	}
	/**
	 * 
	 * @param node
	 * @param level  第几层
	 * @param childNumber  属于父节点的第几个子节点
	 */
	private void recDisplayTree(Node node, int level, int childNumber) {
		System.out.print("level = " + level + " child = " + childNumber + " ");
		node.displayNode();
		int numItems = node.getNumItems();
		for(int j = 0; j < numItems + 1; j++) {
			Node nextNode = node.getChild(j);
			if(nextNode != null) {
				recDisplayTree(nextNode, level + 1, j);
			}else
				return;
		}
	}
}
