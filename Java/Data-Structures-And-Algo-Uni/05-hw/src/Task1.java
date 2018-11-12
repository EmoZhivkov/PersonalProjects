import java.util.Scanner;

public class Task1 {
    static class LinkedList {
        Node root;
        int size;

        LinkedList() {
            this.root = null;
            this.size = 0;
        }

        void insert(int value) {
            if (this.root == null) {
                this.root = new Node(value, this.size);
                this.size++;
                return;
            }

            Node temp = root;


            while (temp.hasNext()) {
                temp = temp.getNext();
            }

            temp.next = new Node(value, this.size);

            size++;
        }

        void print() {
            Node temp = this.root;
            System.out.println(temp.value);

            while (temp.hasNext()) {
                temp = temp.getNext();
                System.out.println(temp.value);
            }
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    static class Node{
        int index;
        int value;
        Node next;

        Node(int value, int index) {
            this.index = index;
            this.value = value;
            this.next = null;
        }

        Node getNext() {
            return this.next;
        }

        boolean hasNext() {
            return this.next != null;
        }
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            linkedList.insert(i);
        }

        Node temp1 = linkedList.root;
        while (temp1.hasNext()) {
            temp1 = temp1.getNext();
        }

        temp1.next = linkedList.root;

        Node temp = linkedList.root;

        while (linkedList.size != 1) {
            temp.next = temp.next.next;
            temp = temp.getNext();

            linkedList.size--;
        }

        System.out.println(temp.value);
    }
}
