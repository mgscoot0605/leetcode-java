package com.mgscoot.data.structure;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode constructTreeNode(String testData) {
        // testData = "[a,b,c,d,.....]" as a String

        if (testData == null || testData.equals("[]")) {
            System.out.printf("%s\n", "construct tree failed, input data is null or empty");
            return null;
        }

        if (testData.indexOf("[") != 0 || testData.indexOf("]") != testData.length()-1) {
            System.out.printf("%s\n", "construct tree failed, input data is invalid");
            return null;
        }

        String data = testData.substring(1, testData.length()-1);
        String[] dataList = data.split(",");
        TreeNode[] nodeArray = new TreeNode[dataList.length];

        for (int i=0; i<dataList.length; i++) {
            if (!dataList[i].equals("null")) {
                TreeNode node = new TreeNode(Integer.valueOf(dataList[i]));
                nodeArray[i] = node;
            }
        }

        // Construct binary tree
        // If the index of root = 0
        // The index of left of the node(index = m) is 2*m +1
        // If the index of root = 1
        // Then the index of left of the node(index = m) is 2*m -1

        for (int i=0; i<nodeArray.length; i++) {
            if (nodeArray[i] != null) {
                int indexOfLeft = i * 2 + 1;
                int indexOfRight = indexOfLeft + 1;

                if (indexOfLeft < nodeArray.length && nodeArray[indexOfLeft] != null) {
                    nodeArray[i].left = nodeArray[indexOfLeft];
                }

                if (indexOfRight < nodeArray.length && nodeArray[indexOfRight] != null) {
                    nodeArray[i].right = nodeArray[indexOfRight];
                }
            }
        }

        return nodeArray[0];
    }

}
