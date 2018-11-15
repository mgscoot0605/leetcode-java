package com.mgscoot.easy._104;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *      3
 *     / \
 *    9  20
 *      /  \
 *    15    7
 * return its depth = 3.
 *
 */

import com.mgscoot.data.structure.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root == null) return depth;
        if(root.left == null && root.right == null) {
            depth = 1;
        } else {
            depth = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }

        return depth;
    }

    public static void main(String[] args) {
        String data = "[3,9,20,null,null,15,7]";
        TreeNode tree = TreeNode.constructTreeNode(data);
        int maxDepth = (new Solution()).maxDepth(tree);

        System.out.printf("Max depth of %s is %d\n", data, maxDepth);


    }

}
