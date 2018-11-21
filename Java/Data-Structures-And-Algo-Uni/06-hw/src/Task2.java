import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    static enum Position {
        ROOT,
        RIGHT,
        LEFT
    }

    static class NodePositionDetails {
        Node node;
        Position pos;
        int hd;

        public NodePositionDetails(Node node, Position pos, int hd) {
            this.node = node;
            this.pos = pos;
            this.hd = hd;
        }
    }

    static void topView(Node root) {
        int reachedRightHD = 0;
        int reachedLeftHD = 0;

        if (root == null) {
            return;
        }

        Queue<NodePositionDetails> nodes = new LinkedList<>();

        Deque<Integer> topViewElements = new ArrayDeque<Integer>();

        NodePositionDetails rootNode = new NodePositionDetails(root, Position.ROOT, 0);
        nodes.add(rootNode);

        while (!nodes.isEmpty()) {
            NodePositionDetails node = nodes.remove();

            if (node.pos.equals(Position.LEFT) && node.hd == reachedLeftHD - 1) {
                topViewElements.addFirst(node.node.data);
                reachedLeftHD -= 1;
            } else if (node.pos.equals(Position.RIGHT) && node.hd == reachedRightHD + 1) {
                topViewElements.addLast(node.node.data);
                reachedRightHD += 1;
            } else if (node.pos.equals(Position.ROOT)) {
                topViewElements.addFirst(node.node.data);
            }

            if (node.node.left != null) {
                nodes.add(new NodePositionDetails(node.node.left, Position.LEFT, node.hd - 1));
            }
            if (node.node.right != null) {
                nodes.add(new NodePositionDetails(node.node.right, Position.RIGHT, node.hd + 1));
            }
        }


        for (Integer x : topViewElements) {
            System.out.print(x + " ");
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}

