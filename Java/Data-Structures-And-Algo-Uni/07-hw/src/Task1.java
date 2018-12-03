import java.util.*;

public class Task1 {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    static class BinaryTree {
        Node root;

        void insert(int value) {
            this.root = insert(this.root, value);
        }

        void deleteKey(int key)
        {
            root = deleteRec(root, key);
        }

        Node deleteRec(Node root, int key)
        {
            /* Base Case: If the tree is empty */
            if (root == null)  return root;

            /* Otherwise, recur down the tree */
            if (key < root.value)
                root.left = deleteRec(root.left, key);
            else if (key > root.value)
                root.right = deleteRec(root.right, key);

                // if key is same as root's key, then This is the node
                // to be deleted
            else
            {
                // node with only one child or no child
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;

                // node with two children: Get the inorder successor (smallest
                // in the right subtree)
                root.value = minValue(root.right);

                // Delete the inorder successor
                root.right = deleteRec(root.right, root.key);
            }

            return root;
        }

        int minValue(Node root)
        {
            int minv = root.value;
            while (root.left != null)
            {
                minv = root.left.value;
                root = root.left;
            }
            return minv;
        }

        boolean search(int value) {
            Node temp = searchHelp(this.root, value);

            return temp.value == value;
        }

        Node searchHelp(Node root, int key)
        {
            if (root==null || root.value==key)
                return root;

            if (root.value > key)
                return searchHelp(root.left, key);

            return searchHelp(root.right, key);
        }

        void preOrderTraversal() {
            preOrder(this.root);
        }

        void postOrderTraversal() {
            postOrder(this.root);
        }

        void inOrderTraversal() {
            inOrder(this.root);
        }

        void preOrder(Node root) {
            if (root == null) {
                return;
            }

            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }


        void postOrder(Node root) {
            if (root == null) {
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);
        }


        void inOrder(Node root) {
            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }


        void printLevelOrderAvg() {
            int h = height(root);
            int i;
            for (i = 0; i < h; i++) {
                getGivenLevel(root, i);

                int cnt = 0;
                double sum = 0;
                for (int num :
                        arrayList) {
                    sum += num;
                    cnt++;
                }
                System.out.println(sum / cnt);

                arrayList.clear();
            }

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
            } else {
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
            else if (level > 0)
            {
                getGivenLevel(root.left, level-1);
                getGivenLevel(root.right, level-1);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            binaryTree.insert(scanner.nextInt());
        }

        binaryTree.printLevelOrderAvg();
    }
}
