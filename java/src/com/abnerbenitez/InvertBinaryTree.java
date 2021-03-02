/**
 * @author Abner Benitez
 * Algorithm: inverting a binary tree
  */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InvertBinaryTree {

    public static void main (String[] args) {
        TreeNode root;

        // [4,2,7,1,3,6,9]
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        InvertBinaryTree.invertTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root != null)
            recursiveSwap(root, root.left, root.right);
        return root;
    }

    public static void recursiveSwap(TreeNode root, TreeNode left, TreeNode right) {
        // null case
        if (left == null && right == null) {
        }

        // right is assumed to not be null
        else if (left == null) {
            root.left = new TreeNode(right.val, right.right, right.left);
            root.right = null;
        }

        // left is assumed to not be null
        else if (right == null) {
            root.right = new TreeNode(left.val, left.right, left.left);
            root.left = null;
            recursiveSwap(root, root.right.left, right.right);
            recursiveSwap(root, left.left, right.right);
        }

        else {
            int tempVal = left.val;
            left.val = right.val;
            right.val = tempVal;

            recursiveSwap(root, left.left, right.right);
            recursiveSwap(root, left.right, right.left);
        }
    }
}