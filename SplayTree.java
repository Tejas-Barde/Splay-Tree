import java.util.LinkedList;
import java.util.Queue;

public class SplayTree {
    private Node root;

    // Function to perform a right rotation (Zig)
    private Node rotateZig(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    // Function to perform a left rotation (Zag)
    private Node rotateZag(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    // Splay function to bring the key to root if exists, else bring the closest
    // node to root
    private Node splay(Node root, int key, int[] steps) {
        if (root == null || root.key == key) {
            return root;
        }

        steps[0]++; // Increment step count

        if (key < root.key) {
            if (root.left == null)
                return root;

            if (key < root.left.key) {
                root.left.left = splay(root.left.left, key, steps);
                root = rotateZig(root);
            } else if (key > root.left.key) {
                root.left.right = splay(root.left.right, key, steps);
                if (root.left.right != null) {
                    root.left = rotateZag(root.left);
                }
            }
            return (root.left == null) ? root : rotateZig(root);
        } else {
            if (root.right == null)
                return root;

            if (key < root.right.key) {
                root.right.left = splay(root.right.left, key, steps);
                if (root.right.left != null) {
                    root.right = rotateZig(root.right);
                }
            } else if (key > root.right.key) {
                root.right.right = splay(root.right.right, key, steps);
                root = rotateZag(root);
            }
            return (root.right == null) ? root : rotateZag(root);
        }
    }

    // Function to insert a key
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        root = splay(root, key, new int[1]);

        if (root.key == key)
            return;

        Node newNode = new Node(key);

        if (key < root.key) {
            newNode.right = root;
            newNode.left = root.left;
            root.left = null;
        } else {
            newNode.left = root;
            newNode.right = root.right;
            root.right = null;
        }

        root = newNode;
    }

    // Modified search function: returns the closest key to the root if the key is
    // not found
    public int search(int key, int[] steps) {
        root = splay(root, key, steps);
        if (root != null && root.key == key) {
            System.out.println("Key " + key + " found.");
        } else {
            System.out.println("Key " + key + " not found. Closest key is " + root.key);
        }
        return root.key;
    }

    // Function to delete a key
    public void delete(int key) {
        if (root == null)
            return;

        root = splay(root, key, new int[1]);

        if (root.key != key)
            return;

        if (root.left == null) {
            root = root.right;
        } else {
            Node temp = root.right;
            root = root.left;
            root = splay(root, key, new int[1]);
            root.right = temp;
        }
    }

    // Function to perform level order traversal of the tree
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.key + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        System.out.println();
    }

    // Function to print the tree structure directly
    public void printTree() {
        printSubtree(root, "", true);
    }

    private void printSubtree(Node node, String indent, boolean isRight) {
        if (node == null) {
            return;
        }

        printSubtree(node.right, indent + (isRight ? "        " : " |      "), true);

        System.out.println(indent + (isRight ? " /" : " \\") + "----- " + node.key);

        printSubtree(node.left, indent + (isRight ? " |      " : "        "), false);
    }
}
