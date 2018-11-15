package com.mgscoot.easy._101;

/**
 *  101. Symmetric Tree
 *  Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *  For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *      1
 *     / \
 *    2   2
 *   / \ / \
 *  3  4 4  3
 *  But the following [1,2,2,null,3,null,3] is not:
 *      1
 *     / \
 *    2   2
 *     \   \
 *      3   3
 *  Note:
 *  Bonus points if you could solve it both recursively and iteratively.
 */

import com.mgscoot.data.structure.TreeNode;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isInvert(root.left, root.right);
    }

    public boolean isInvert(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null && p.val == q.val) {
            return isInvert(p.left, q.right) && isInvert(p.right, q.left);
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode tree = getTestData(2);
        Solution s = new Solution();
        boolean result = s.isSymmetric(tree);
        System.out.printf("Result: %b\n", result);
    }

    public static TreeNode getTestData(int example) {
        String data = "";
        switch(example) {
            case 1:
                data = "[1,2,2,3,4,4,3]";
                break;
            case 2:
                data = "[1,2,2,null,3,null,3]";
                break;
        }

        TreeNode node = TreeNode.constructTreeNode(data);
        return node;
    }

}
