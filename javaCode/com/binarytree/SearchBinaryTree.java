package com.binarytree;


/**
 * ���Ҷ�����
 * @author huxm
 *
 */
public class SearchBinaryTree {

	private TreeNode root;
	
	public SearchBinaryTree() {
		
	}
	
	/**
	 * �������Ҷ�����
	 * @author huxm
	 *
	 */
	public TreeNode put(int data) {
		TreeNode node = null;
		TreeNode parent = null;
		// ������ǿյ�,��Ѵ����ֹ�����һ���ڵ㣬��Ϊ��
		if(root == null) {
			node = new TreeNode(0,data);
			root = node;
			return root;
		}
		// �����ڵ㸳ֵ��node���Ӹ���ʼ�ж�
		node = root;
		while(node != null) {
			// ���ڵ�
			parent = node;
			if(data > node.data) {
				node = node.rightChild;
			}else if(data < node.data){
				node = node.leftChild;
			}else {
				return node;
			}
		}
		// ��ʾ���˽����ӵ���Ӧ��λ��
		node = new TreeNode(0, data);
		if(data < parent.data) {
			parent.leftChild = node;
		}else {
			parent.rightChild = node;
		}
		node.parent = parent;
		return node;
	}
	
	/**
	 * ɾ���ڵ�
	 */
	public void deleteNode(int key) throws Exception {
		TreeNode node = searchNode(key);
		if(node == null) {
			throw new Exception("�ý���޷��ҵ���");
		}else {
			// ɾ���ý��
			delete(node);
		}
	}
	
	/**
	 * ���ҽڵ�
	 */
	private TreeNode searchNode(int key) {
		TreeNode node = root;
		if(node == null) {
			return null;
		}else {
			while(node != null && key != node.data) {
				if(key < node.data) {
					node = node.leftChild;
				}else {
					node = node.rightChild;
				}
			}
		}
		// ��ֱ����һ����˵���ҵ��ˣ�����û�ҵ���û�ҵ���Ϊ�գ���nodeֵΪ�գ�
		return node;
	}
	
	private void delete(TreeNode node) throws Exception {
		if(node == null) {
			throw new Exception("�ý���޷��ҵ���");
		}
		TreeNode parent = node.parent;
		// ��ɾ���Ľڵ���Ҷ�ӽڵ㣺����Ҳ���Һ���
		if(node.leftChild == null && node.rightChild == null) {
			if(parent.leftChild == node) {
				parent.leftChild = null;
			}else {
				parent.rightChild = null;
			}
			return;
		}
		
		// ��ɾ���Ľڵ�ֻ�����ӣ�����
		if(node.leftChild != null && node.rightChild == null) {
			if(parent.leftChild == node) {
				parent.leftChild = node.leftChild;
			}else {
				parent.rightChild = node.leftChild;
			}
			return;
		}
		
		// ��ɾ���Ľڵ�ֻ���Һ��ӣ�����
		if(node.leftChild == null && node.rightChild != null) {
			if(parent.leftChild == node) {
				parent.leftChild = node.rightChild;
			}else {
				parent.rightChild = node.rightChild;
			}
			return;
		}
		
		/**
		 * ��ɾ���Ľڵ㣬�����������Һ��ӣ��ҵ���̽��
		 * �����̽�㣬һ����Ҷ�ӽڵ�
		 */
		TreeNode nextNode = getNextNode(node);
		delete(nextNode);
		
	}
	
	private TreeNode getNextNode(TreeNode node) {
		if(node == null) {
			return null;
		}
		if(node.rightChild != null) {
			// ��ĳ���Ͻ����С�ؼ��ֽ��
			return getMinTreeNode(node.rightChild);
		}else {
			TreeNode parent = node.parent;
			while(parent != null && node == parent.rightChild) {
				node = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}

	private TreeNode getMinTreeNode(TreeNode node) {
		if(node == null) {
			return null;
		}
		while(node.leftChild != null) { // �������Ϊ�գ���������ѭ��
			node = node.leftChild;
		}
		return node;
	}
	
	/**
	 * ǰ�����
	 */
	public void preOrder(TreeNode node) {
		if(node == null) {
			return;
		}
		System.out.println(node.data);
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}

	/**
	 * �������
	 */
	public void midOrder(TreeNode node) {
		if(node == null) {
			return;
		}else {
			midOrder(node.leftChild);
			System.out.println(node.data);
			midOrder(node.rightChild);
		}
	}
	
	/**
	 * �ڲ��ࣺTreeNode
	 * @author huxm
	 *
	 */
	class TreeNode{
		private int key;
		private int data;
		private TreeNode leftChild;
		private TreeNode rightChild;
		private TreeNode parent;
		
		// ���캯��
		public TreeNode(int key, int data) {
			super();
			this.key = key;
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
			this.parent = null;
		}
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public TreeNode getLeftChild() {
			return leftChild;
		}
		public void setLeftChild(TreeNode leftChild) {
			this.leftChild = leftChild;
		}
		public TreeNode getRightChild() {
			return rightChild;
		}
		public void setRightChild(TreeNode rightChild) {
			this.rightChild = rightChild;
		}
		public TreeNode getParent() {
			return parent;
		}
		public void setParent(TreeNode parent) {
			this.parent = parent;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		SearchBinaryTree bt = new SearchBinaryTree();
		int[] intArr = new int[]{50,30,20,44,88,33,87,16,7,77};
		for(int i : intArr) {
			bt.put(i);
		}
		bt.midOrder(bt.root);
		System.out.println("============");
//		bt.preOrder(bt.root);
		// ɾ��һ���ڵ�
		try {
			bt.deleteNode(44);
			bt.midOrder(bt.root);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
