package com.interviewbit.trees;

public class IdenticalTrees {
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

		System.out.println(isSameTree(n1, n2));
	}

	static public int isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return 1;
		} else if (p != null && q != null) {
			if (p.val == q.val) {
				return isSameTree(p.left, q.left) & isSameTree(q.right, p.right);
			}
		} else {
			return 0;
		}

		return 0;
	}
}
