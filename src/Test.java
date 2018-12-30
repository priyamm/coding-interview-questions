
public class Test {
	public static int findLargest(BinaryTreeNode node) {
		if(node.getRight() != null)
			return findLargest(node.getRight());
		return node.getData();
	}
	
	public static void main(String... args) {
		BinaryTree tree = new BinaryTree(10);
		
		
	}
}


class BinaryTree {
	private int data;
	private BinaryTree left;
	private BinaryTree right;
	public BinaryTree() {
	}
	public BinaryTree(int data) {
		this.data = data;
	}
	public BinaryTree insertLeft(int data) {
		this.left = new BinaryTree(5);
		return this.left;
	}
	
	public BinaryTree insertRIght(int data) {
		this.right = new BinaryTree(7);
		return this.right;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryTree getLeft() {
		return left;
	}
	public void setLeft(BinaryTree left) {
		this.left = left;
	}
	public BinaryTree getRight() {
		return right;
	}
	public void setRight(BinaryTree right) {
		this.right = right;
	}
	
}
