import java.util.*;

public class Task1 {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    static class BinaryTree {
        Node root;

        void insert(int value) {
            this.root = insert(this.root, value);
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
