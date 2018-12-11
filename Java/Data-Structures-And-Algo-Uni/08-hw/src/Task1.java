import java.util.Scanner;

public class Task1 {
    static class Node {
        double value;
        int height;
        Node left;
        Node right;

        Node(double value) {
            this.value = value;
            this.height = 1;
        }
    }

    static class AVLTree {
        private Node root;

        boolean containsRecursive(Node current, double value) {
            if (current == null) {
                return false;
            }

            if (current.value == value) {
                return true;
            }

            if (value < current.value) {
                return containsRecursive(current.left, value);
            } else {
                return containsRecursive(current.right, value);
            }
        }

        void printRecursive(Node current) {
            if (current == null) {
                return;
            }

            printRecursive(current.left);
            System.out.printf("%.6f", current.value);
            System.out.print(" ");
            printRecursive(current.right);
        }

        int height(Node N) {
            if (N == null)
                return 0;

            return N.height;
        }

        int max(int a, int b) {
            return (a > b) ? a : b;
        }

        Node rightRotate(Node y) {
            Node x = y.left;
            Node T2 = x.right;

            x.right = y;
            y.left = T2;

            y.height = max(height(y.left), height(y.right)) + 1;
            x.height = max(height(x.left), height(x.right)) + 1;

            return x;
        }

        Node leftRotate(Node x) {
            Node y = x.right;
            Node T2 = y.left;

            y.left = x;
            x.right = T2;

            x.height = max(height(x.left), height(x.right)) + 1;
            y.height = max(height(y.left), height(y.right)) + 1;

            return y;
        }

        int getBalance(Node N) {
            if (N == null)
                return 0;

            return height(N.left) - height(N.right);
        }

        Node minValueNode(Node node) {
            Node current = node;

            while (current.left != null)
                current = current.left;

            return current;
        }

        AVLTree() {
            root = null;
        }

        void add(double value) {
            this.root = this.insert(this.root, value);
        }

        Node insert(Node node, double value) {

            if (node == null)
                return (new Node(value));

            if (value < node.value) {
                node.left = insert(node.left, value);
            } else if (value > node.value) {
                node.right = insert(node.right, value);
            } else if (value == node.value) {
                System.out.printf("%.6f", value);
                System.out.println(" already added");
            } else
                return node;

            node.height = 1 + max(height(node.left),
                    height(node.right));

            int balance = getBalance(node);

            if (balance > 1 && value < node.left.value)
                return rightRotate(node);

            if (balance < -1 && value > node.right.value)
                return leftRotate(node);

            if (balance > 1 && value > node.left.value) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            if (balance < -1 && value < node.right.value) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        void remove(double value) {
            this.root = this.deleteNode(this.root, value);
        }

        Node deleteNode(Node root, double value) {
            if (root == null) {
                System.out.printf("%.6f", value);
                System.out.println(" not found to remove");
                return root;
            }

            if (value < root.value) {
                root.left = deleteNode(root.left, value);
            } else if (value > root.value) {
                root.right = deleteNode(root.right, value);
            } else {
                if ((root.left == null) || (root.right == null)) {
                    Node temp = null;
                    if (temp == root.left)
                        temp = root.right;
                    else
                        temp = root.left;

                    if (temp == null) {
                        temp = root;
                        root = null;
                    } else
                        root = temp;
                } else {
                    Node temp = minValueNode(root.right);

                    root.value = temp.value;

                    root.right = deleteNode(root.right, temp.value);
                }
            }

            if (root == null)
                return root;

            root.height = max(height(root.left), height(root.right)) + 1;

            int balance = getBalance(root);

            if (balance > 1 && getBalance(root.left) >= 0)
                return rightRotate(root);

            if (balance > 1 && getBalance(root.left) < 0) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }

            if (balance < -1 && getBalance(root.right) <= 0)
                return leftRotate(root);

            if (balance < -1 && getBalance(root.right) > 0) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }

            return root;
        }

        boolean contains(double value) {
            if (root == null) {
                return false;
            }

            return containsRecursive(root, value);
        }

        void print() {
            if (root == null) {
                return;
            }

            printRecursive(root);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AVLTree tree = new AVLTree();
        String operation;

        double number = 0;
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            operation = scanner.next();
            if (!operation.equals("print")) {
                number = scanner.nextDouble();
            }

            if (operation.equals("add")) {
                tree.add(number);
            } else if (operation.equals("remove")) {
                tree.remove(number);
            } else if (operation.equals("contains")) {
                if (tree.contains(number)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else if (operation.equals("print")) {
                tree.print();
            }
        }
    }
}
