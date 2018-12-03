import java.util.*;
import java.io.*;

class Node {
    Node leftNode;
    Node rightNode;
    int data;

    Node(int data) {
        this.data = data;
        leftNode = null;
        rightNode = null;
    }
}

class Solution {
    static int helper = 0;

    public static void print(Node root) {
        printHelp(root, helper);
    }

    public static void printHelp(Node root, int curr) {
        if (root == null) {
            return;
        }
        printHelp(root.rightNode, curr - 1);
        printHelp(root.leftNode, curr - 1);


        if (curr == helper) {
            System.out.print(root.data);
        } else {
            System.out.print(root.data + ";");
        }


    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.leftNode, data);
                root.leftNode = cur;
            } else {
                cur = insert(root.rightNode, data);
                root.rightNode = cur;
            }
            return root;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        helper = t;

        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        print(root);
    }
}