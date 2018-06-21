package org.binarytree;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.insert(5);
        root.insert(15);
        root.insert(8);

        System.out.println(root.printInOrder());
    }
}
