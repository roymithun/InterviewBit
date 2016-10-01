package com.interviewbit.trees;

public class MaximumDepthBinaryTree {

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 1;
		int hL = 1 + maxDepth(root.left);
		int hR = 1 + maxDepth(root.right);
		return Math.max(hL, hR);
	}
}
