/**
 * 
 */
package com.priyam.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author prigupta8
 *
 */
public class TreeView {
	
	/**
	 * 
	 * 			5
	 * 
	 * 		3		4
	 * 
	 * 			7		8
	 * 
	 * 		10
	 * 
	 * 	12
	 * 
	 * 
	 */
	
	private Node root;
	
	private static Integer MAX_LEVEL = -1;
	
	
	
	
	public static void main(String[] args) {
		
		TreeView treeView = new TreeView();
		treeView.root = new Node(5);
		treeView.root.left = new Node(3);
		treeView.root.right = new Node(4);
		treeView.root.right.left = new Node(7);
		treeView.root.right.right = new Node(8);
		treeView.root.right.left.left = new Node(10);
		treeView.root.right.left.left.left = new Node(12);
		
		levelOrderTraversal(treeView.root);
		
		topView(treeView.root);
		leftView(treeView.root, 0);
		rightView(treeView.root);
		bottomView(treeView.root);
		
	}


	/**
	 * @param root2
	 * 
	 * 5 3 4 7 8 10 12 
	 */
	private static void levelOrderTraversal(Node root) {
		
		if(root == null)
			return;
		
		Queue<Node> nodeQueue = new LinkedList<>();

		nodeQueue.add(root);
		
		while(!nodeQueue.isEmpty()) {
			Node node = nodeQueue.poll();
			System.out.print(node.data + " ");
			
			if(node.left != null)
				nodeQueue.add(node.left);
			if(node.right != null)
				nodeQueue.add(node.right);
		}
		
	}



	/**
	 * @param root
	 * 
	 * 5 3 4 12 8 
	 * 
	 */
	private static void topView(Node root) {
		
		if(root == null)
			return;
		
		class QueueObj {
			Node node;
			int level;
			
			/**
			 * 
			 */
			public QueueObj(Node node, int level) {
				this.node = node;
				this.level = level;
			}
		}
		
		Queue<QueueObj> queue = new LinkedList<>();
		Map<Integer, Integer> nodeMap = new HashMap<>();
		
		queue.add(new QueueObj(root, 0));
		
		while(!queue.isEmpty()) {
			QueueObj queueObj = queue.poll();
			if(nodeMap.get(queueObj.level) == null)
				nodeMap.put(queueObj.level, queueObj.node.data);
			if(queueObj.node.left != null)
				queue.add(new QueueObj(queueObj.node.left, queueObj.level - 1));
			if(queueObj.node.right != null)
				queue.add(new QueueObj(queueObj.node.right, queueObj.level + 1));
		}
		
		nodeMap.entrySet().forEach(x -> System.out.print(x.getValue() + " "));
		
	}






	/**
	 * @param root2
	 */
	private static void bottomView(Node root) {
		
		if(root == null)
			return;
		
		Map<Integer, Integer> nodeMap = new HashMap<>();
		
		// right view using depth traversal
		bottomViewUtil(nodeMap, 0, root);
		
		nodeMap.entrySet().forEach(x -> System.out.print(x.getValue() + " "));
		
	}
	
	/**
	 * @param nodeQueue
	 * @param nodeMap
	 * 7 10 4 12 8
	 * @param i
	 */
	private static void bottomViewUtil(Map<Integer, Integer> nodeMap, int level, Node root) {
		
		if(root == null)
			return;
		
		nodeMap.put(level, root.data);
		
		bottomViewUtil(nodeMap, level - 1, root.left);
		bottomViewUtil(nodeMap, level + 1, root.right);
		
	}



	/**
	 * @param root2
	 * @param i
	 * 
	 * 5 4 8 10 12 
	 * 
	 */
	private static void rightView(Node root) {
		
		if(root == null)
			return;
		
		Map<Integer, Integer> nodeMap = new HashMap<>();
		
		// right view using depth traversal
		rightViewUtil(nodeMap, 0, root);
		
		nodeMap.entrySet().forEach(x -> System.out.print(x.getValue() + " "));
		
	}






	/**
	 * @param nodeQueue
	 * @param nodeMap
	 * @param i
	 */
	private static void rightViewUtil(Map<Integer, Integer> nodeMap, int level, Node root) {
		
		if(root == null)
			return;
		
		nodeMap.put(level, root.data);
		
		rightViewUtil(nodeMap, level + 1, root.left);
		rightViewUtil(nodeMap, level + 1, root.right);
		
	}






	/**
	 * @param root2
	 * 
	 * 	5
		3
		7
		10
		12
	 * 
	 *	
	 *
	 */
	private static void leftView(Node root, int level) {
		
		if(root == null)
			return;
		
		if(level > MAX_LEVEL) {
			MAX_LEVEL = level;
			System.out.println(root.data);
		}
		
		leftView(root.left, level + 1);
		
		leftView(root.right, level + 1);
		
	}
	
}

