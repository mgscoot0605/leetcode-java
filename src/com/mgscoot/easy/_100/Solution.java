package com.mgscoot.easy._100;

/**
 *  100. Same Tree
 *
 *  Given two binary trees, write a function to check if they are the same or not.
 *  Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 *  Example 1:
 *      Input:     1         1
 *                / \       / \
 *               2   3     2   3
 *
 *              [1,2,3],   [1,2,3]
 *
 *      Output: true
 *
 *  Example 2:
 *      Input:     1         1
 *                /           \
 *               2             2
 *
 *               [1,2],     [1,null,2]
 *
 *       Output: false
 *
 *  Example 3:
 *  Input:     1         1
 *            / \       / \
 *           2   1     1   2
 *
 *          [1,2,1],   [1,1,2]
 *
 *  Output: false
 *
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import com.mgscoot.data.structure.TreeNode;
import java.util.List;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {

//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) {
//            val = x;
//        }
//    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

    }

    // Not proven solution,
    public boolean isSameTreeIter(TreeNode p, TreeNode q) {
        System.out.printf("%s\n", "go to isSameTree()");
        boolean isSame = false;
        List<Integer> pList = traversalTree(p);
        List<Integer> qList = traversalTree(q);

        System.out.printf("pList = %s\n", pList.toString());
        System.out.printf("qList = %s\n", qList.toString());

        if(pList == null && qList == null) {
            isSame = true;
        }

        if(pList != null && qList != null && pList.size() == qList.size()) {
            for(int i=0; i<pList.size(); i++) {
                System.out.printf("%d\n", i);
                if(pList.get(i) != qList.get(i)) {
                    break;
                }
                if(i == pList.size()-1) {
                    System.out.printf("%s\n", "match!!");
                    isSame = true;
                }
            }
        }

        return isSame;
    }

    public List<Integer> traversalTree(TreeNode treeNode) {
        System.out.printf("%s\n", "go to traversalTree()");
        if(treeNode == null) {
            System.out.printf("%s\n", "traversalTree(): treeNode is null");
            return null;
        }

        // Traversal trees by pre-order
        List<Integer> output = new ArrayList();
        Stack<TreeNode> stack = new Stack();

        stack.push(treeNode);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.add(node.val);
            System.out.printf("--- output = %s\n", output.toString());
            if(node.right != null) {
                stack.push(node.right);
                if(node.left == null) {
                    output.add(null);
                }
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.printf("%s\n", "process start...");
        Solution s = new Solution();
        TreeNode p = s.constructTreeNodeA();
        TreeNode q = s.constructTreeNodeB();
        System.out.printf("%s\n", "data prepare ready...");
        boolean result = s.isSameTree(p,q);
        System.out.printf("Result = %b\n", result);
        System.out.printf("%s\n", "process end...");
    }

    public TreeNode constructTreeNodeA() {
        // Example 1
        String data = "[1,2,3]";

        // Example 2
//        String data = "[1,2]";

        // Example 3
//        String data = "[1,2,1]";

        TreeNode tree = TreeNode.constructTreeNode(data);

        return tree;
    }

    public TreeNode constructTreeNodeB() {
        // Example 1
        String data = "[1,2,3]";

        // Example 2
//        String data = "[1,null,2]";

        // Example 3
//        String data = "[1,1,2]";

        TreeNode tree = TreeNode.constructTreeNode(data);
        return tree;
    }
}
