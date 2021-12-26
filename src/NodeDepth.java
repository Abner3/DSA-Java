/*
Write a function that takes in a Binary Tree and returns the sum of its nodes' depths
*/

public class NodeDepth {
    public static int nodeDepths(BinaryTree root) {
        // Check for edge case: root is null
        if (root == null)
            return 0;

        return nodeDepthHelper(root, 0);
    }

    public static int nodeDepthHelper(BinaryTree node, int currDepth) {
        int totalDepth = 0;

        // if leaf node
        if (node.left == null && node.right == null)
            return currDepth;

        // if non-leaf node
        // if left node exists
        if (node.left != null) {
            totalDepth += nodeDepthHelper(node.left, currDepth + 1);
        }

        // if right node exists
        if (node.right != null) {
            totalDepth += nodeDepthHelper(node.right, currDepth + 1);
        }

        return totalDepth + currDepth;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

}
