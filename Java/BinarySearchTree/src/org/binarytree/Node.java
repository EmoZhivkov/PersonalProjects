package org.binarytree;

public class Node {
    private Node left, right;
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int data) {
        if (data <= this.data) {
            if (this.left == null) {
                this.left = new Node(data);
            } else {
                this.left.insert(data);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(data);
            } else {
                this.right.insert(data);
            }
        }
    }

    public boolean contains(int data) {
        boolean b = false;
        if (this.data == data) {
            b = true;
        } else if (this.data > data) {
            if (this.left == null) {
                b = false;
            } else {
                b = this.left.contains(data);
            }
        } else if (this.data < data) {
            if (this.right == null) {
                b = false;
            } else {
                b = this.right.contains(data);
            }
        }
        return b;
    }

    public String printInOrder() {
        String string = "";
        if (this.left != null) {
            string = string + this.left.printInOrder() ;
        }
        string = string + this.data + ", ";
        if (this.right != null) {
            string = string + this.right.printInOrder();
        }
        return string;
    }
}
