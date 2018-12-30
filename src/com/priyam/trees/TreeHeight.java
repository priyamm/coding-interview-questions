/**
 * 
 */
package com.priyam.trees;

/**
 * @author prigupta8
 *
 */
public class TreeHeight {
	
	Node root;
	
	public int height(Node root) {
		if(root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.left));
	}
	
	public static void main(String... args) {
		TreeHeight tree = new TreeHeight();
		tree.root = new Node(32);
		tree.root.left = new Node(2);
		tree.root.right = new Node(46);
		tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5);
        
        System.out.println("Height : " + tree.height(tree.root));
	}

}

class Node {
	int data;
	Node left, right;
	/**
	 * 
	 */
	public Node(int x) {
		// TODO Auto-generated constructor stub
		this.data = x;
		this.left = this.right = null;
	}
}
