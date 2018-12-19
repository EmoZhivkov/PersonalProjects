import java.util.*;

public class Task1 {

    static class BinaryTree {
        Node root;
        long size;

        void insert(long value) {
            this.root = insert(this.root, value);
        }

        class Node {
            long value;
            Node left, right;

            Node(long value) {
                this.value = value;
                this.left = null;
                this.right = null;
            }
        }

        Node insert(Node root, long value) {
            if (root == null) {
                this.size++;
                root = new Node(value);
                return root;
            }

            if (value < root.value) {
                root.left = insert(root.left, value);
            } else if (value > root.value) {
                root.right = insert(root.right, value);
            }

            return root;
        }
    }

    public static void main(String[] args) {
        BinaryTree set = new BinaryTree();

        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();

        for (long i = 0; i < len; i++) {
            set.insert(scanner.nextLong());
        }

        System.out.println(set.size);
    }
}
