package com.interviewbit.trees;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);

		n2.left = n3;
		n2.right = n4;

		n5.right = n6;

		n1.left = n2;
		n1.right = n5;

		flattenIterative(n1);
		System.out.println(n1);
	}

	static public void flatten(TreeNode root) {
		if (root == null)
			return;
		flattenRecursive(root, null);
	}

	static public TreeNode flattenRecursive(TreeNode root, TreeNode tail) {
		if (root == null)
			return tail;
		root.right = flattenRecursive(root.left, flattenRecursive(root.right, tail));
		root.left = null;
		return root;
	}

	static public void flattenIterative(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		stk.push(root);
		while (!stk.empty()) {
			TreeNode cur = stk.pop();
			if (cur.right != null)
				stk.push(cur.right);
			if (cur.left != null)
				stk.push(cur.left);
			cur.left = null;
			cur.right = stk.empty() ? null : stk.peek();
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
