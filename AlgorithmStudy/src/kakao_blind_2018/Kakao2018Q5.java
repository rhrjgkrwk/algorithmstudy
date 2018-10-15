package kakao_blind_2018;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	String item;
	Node left;
	Node right;

	public Node(String item) {
		this.item = item;
		this.left = null;
		this.right = null;
	}
	
	public Node(String item, Node left, Node right) {
		super();
		this.item = item;
		this.left = left;
		this.right = right;
	}

	public Node() {

	}
}

class BTree {
	Node root;

	public BTree() {
	}
	
	public BTree(Node root) {
		super();
		this.root = root;
	}

	public void preTraverse(Node now) {
		if (now != null) {
			System.out.print(now.item + " ");
			preTraverse(now.left);
			preTraverse(now.right);
		}
	}

	public void inTraverse(Node now) {
		if (now != null) {
			inTraverse(now.left);
			System.out.print(now.item + " ");
			inTraverse(now.right);
		}
	}

	public void postTraverse(Node now) {
		if (now != null) {
			postTraverse(now.left);
			postTraverse(now.right);
			System.out.print(now.item + " ");
		}
	}
	
	public void levelTraverse(Node start) {
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			Node now = q.poll();
			System.out.print(now.item + " ");
			if (now.left != null) {
				q.add(now.left);
			}
			if (now.right != null) {
				q.add(now.right);
			}
		}
	}
	
	public int height(Node node) {
		if (node == null) {
			return 0;
		}
		else {
			return 1+(Math.max(height(node.left),height(node.right)));
		}
	}
	
}

public class Kakao2018Q5 {
	public static void main(String[] args) {
		BTree bt = new BTree();
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		Node h = new Node("h");
		Node i = new Node("i");
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		d.left = h;
		d.right = i;
		c.left = f;
		c.right = g;
		bt.root = a;
		
		System.out.println("===================");
		bt.preTraverse(bt.root);
		System.out.println();
		System.out.println("===================");
		bt.inTraverse(bt.root);
		System.out.println();
		System.out.println("===================");
		bt.postTraverse(bt.root);
		System.out.println();
		System.out.println("===================");
		bt.levelTraverse(bt.root);
		System.out.println();
		System.out.println(bt.height(bt.root));
	}
}
