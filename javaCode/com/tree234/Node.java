package com.tree234;

public class Node {

	private static final int ORDER = 4;
	private int numItems;
	private Node parent;
	// 子节点
	private Node[] childArray = new Node[ORDER];
	// 数据项
	private DataItem[] itemArray = new DataItem[ORDER - 1];
	/**
	 * 取子节点
	 * @param childNum
	 * @return
	 */
	public Node getChild(int childNum) {
		return childArray[childNum];
	}
	
	/**
	 * 取父节点
	 * @return
	 */
	public Node getParent() {
		return parent;
	}
	
	/**
	 * 是不是叶节点
	 * @return
	 */
	public boolean isLeaf() {
		return childArray[0] == null ? true : false;
	}
	
	public int getNumItems() {
		return numItems;
	}
	
	/**
	 * 获取某个数据项
	 * @param index
	 * @return
	 */
	public DataItem getItem(int index) {
		return itemArray[index];
	}
	
	public boolean isFull() {
		return (numItems == ORDER - 1) ;
	}
	
	/**
	 * 连接子节点
	 */
	public void connectChild(int childNum, Node child) {
		childArray[childNum] = child;
		if(child != null) child.parent = this;
	}
	
	/**
	 * 拆分子节点
	 */
	public Node disconnectChild(int childNum) {
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}
	
	/**
	 * 查找数据项
	 */
	public int findItem(long key) {
		for(int j = 0; j < ORDER - 1; j++) {
			if(itemArray[j] == null) break;
			else if(itemArray[j].dData == key) return j;
		}
		return -1; // 没找到
	}
	
	/**
	 * 插入数据项
	 */
	public int insertItem(DataItem newItem) {
		numItems++;
		long newKey = newItem.dData;
		for(int j = ORDER - 2; j >= 0; j--) {
			if(itemArray[j] == null) continue;
			else {
				long itsKey = itemArray[j].dData;
				if(newKey < itsKey) {
					itemArray[j + 1] = itemArray[j];
				}else {
					itemArray[j + 1] = newItem;
					return j + 1;
				}
			}
		}
		itemArray[0] = newItem;
		return 0;
	}
	
	/**
	 * 删除数据项
	 */
	public DataItem removeItem() {
		DataItem temp = itemArray[numItems - 1];
		itemArray[numItems - 1] = null;
		numItems--;
		return temp;
	}
	
	public void displayNode() {
		for(int j = 0; j < numItems; j++) {
			itemArray[j].displayItem();
		}
	}
	
}
