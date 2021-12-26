import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LeafSum {
    /*
    given a binary tree of integers, returns the sums of all the root-to-leaf paths.
Input:
      2
     / \
    3   5
  /  \
 1    5


 Output:[6, 10, 7]
     */

    public static List<Integer> sums2(BST node, int currSum) {
        // concat Lists
        List<Integer> sol = new ArrayList<>();

        // if node is leaf
        if (node.left == null && node.right == null)
            return List.of(currSum + node.val);

        // if there exists a left node
        // concat sums of left node
        if (node.left != null)
            sol.addAll(sums2(node.left, currSum + node.val));

        // if there exists a right node
        if (node.right != null)
            sol.addAll(sums2(node.right, currSum + node.val));

        return sol;
    }


    public static List<Integer> sol = new ArrayList<>();

    public static void sums(BST node, int currSum) {
        // if node is a leaf
        if (node.left == null && node.right == null)
            sol.add(currSum + node.val);

        // else, node is not a leaf
        // if there exists a left child
        if (node.left != null)
            sums(node.left, currSum + node.val);

        // if there exists a right child
        if (node.right != null)
            sums(node.right, currSum + node.val);
    }

    public static class BST {
        public int val;
        public BST left, right;

        public BST(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        BST root = new BST(2);
        root.left = new BST(3);
        root.right = new BST(5);
        BST temp = root.left;
        temp.left = new BST(1);
        temp.right = new BST(5);

        sums(root, 0);

        System.out.println(sol);
        System.out.println(sums2(root, 0));

        List<Integer> test = sums2(root, 0);
        Integer[] arr1 = test.toArray(new Integer[0]);
        Arrays.stream(arr1).forEach((i) -> {
            System.out.print(i + ", ");
        });
        System.out.println("\n" + Arrays.toString(arr1));
    }
}
