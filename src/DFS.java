import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
Implement Depths First Search on the Node class
*/

public class DFS {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();
        Deque<Node> queue = new ArrayDeque<Node>();

        // Helper class
        public Node(String name) {
            this.name = name;
        }

        // Helper function
        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }

        public List<String> depthFirstSearch(List<String> array) {
            // use a stack
            array.add(this.name);
            for (int i = children.size() - 1; i >= 0; i--) {
                queue.addFirst(children.get(i));
            }
            while (!queue.isEmpty()) {
                Node poppedNode = queue.removeFirst();
                array.add(poppedNode.name);
                // recurse through poppedNode's children
                for (int i = poppedNode.children.size() - 1; i >= 0; i--) {
                    queue.addFirst(poppedNode.children.get(i));
                }
            }
            return array;
        }
    }
}
