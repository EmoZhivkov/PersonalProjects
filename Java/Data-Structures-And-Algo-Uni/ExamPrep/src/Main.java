import java.util.*;

public class Main {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    static class BinaryTree {
        Node root;

        void insert(int value) {
            this.root = insert(this.root, value);
        }

        void deleteKey(int key) {
            root = deleteRec(root, key);
        }

        Node deleteRec(Node root, int key) {
            if (root == null) return root;

            if (key < root.value)
                root.left = deleteRec(root.left, key);
            else if (key > root.value)
                root.right = deleteRec(root.right, key);

            else {
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;

                root.value = minValue(root.right);

                root.right = deleteRec(root.right, root.value);
            }

            return root;
        }

        int minValue(Node root) {
            int minv = root.value;
            while (root.left != null) {
                minv = root.left.value;
                root = root.left;
            }
            return minv;
        }

        boolean search(int value) {
            Node temp = searchHelp(this.root, value);

            return temp.value == value;
        }

        Node searchHelp(Node root, int key) {
            if (root == null || root.value == key)
                return root;

            if (root.value > key)
                return searchHelp(root.left, key);

            return searchHelp(root.right, key);
        }

        void preOrderTraversal() {
            preOrder(this.root);
        }


        void preOrder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }


        class Node {
            int value;
            Node left, right;

            Node(int value) {
                this.value = value;
                this.left = null;
                this.right = null;
            }
        }

        Node insert(Node root, int value) {
            if (root == null) {
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

        int height(Node root) {
            if (root == null)
                return 0;
            else {
                int lheight = height(root.left);
                int rheight = height(root.right);

                if (lheight > rheight)
                    return (lheight + 1);
                else return (rheight + 1);
            }
        }

        void getGivenLevel(Node root, int level) {
            if (root == null)
                return;
            if (level == 0)
                arrayList.add(root.value);
            else if (level > 0) {
                getGivenLevel(root.left, level - 1);
                getGivenLevel(root.right, level - 1);
            }
        }

        void printLevelOrder() {
            int h = height(root);
            int i;
            for (i = 0; i < h; i += 2) {
                getGivenLevel(root, i);

                    for (int num :
                            arrayList) {
                        System.out.print(num + " ");
                    }
                    arrayList.clear();


            }

        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int tries = scanner.nextInt();

        BinaryTree tree = new BinaryTree();

        for (int i = 0; i < tries; i++) {
            String function = scanner.next();

            if (function.equals("add")) {
                int num = scanner.nextInt();
                tree.insert(num);
            } else if (function.equals("print")) {
                tree.preOrderTraversal();
            } else if (function.equals("remove")) {
                int num = scanner.nextInt();
                tree.deleteKey(num);
            } else if (function.equals("print_odd_layers")) {
                tree.printLevelOrder();
            }
        }
    }
}