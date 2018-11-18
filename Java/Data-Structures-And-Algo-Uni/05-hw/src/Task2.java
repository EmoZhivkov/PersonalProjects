import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            String stone = scanner.next();
            int n = scanner.nextInt();

            if (stone.equals("green")) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += linkedList.pop();
                }
                linkedList.push(sum);
            } else if (stone.equals("blue")) {
                int biggest = linkedList.pop();
                for (int j = 1; j < n; j++) {
                    if (linkedList.peek() > biggest) {
                        biggest = linkedList.pop();
                        continue;
                    }
                    linkedList.pop();
                }
                linkedList.push(biggest);
            } else {
                linkedList.push(n);
            }
        }

        LinkedList temp = new LinkedList();
        while (!linkedList.isEmpty()) {
            temp.push(linkedList.pop());
        }

        while (!temp.isEmpty()) {
            System.out.print(temp.pop() + " ");
        }

    }

    static class LinkedList {
        Node root;
        int size;

        LinkedList() {
            this.root = null;
            this.size = 0;
        }

        void push(int value) {
            root = new Node(value, root);
            this.size++;
        }

        int pop() {
            int num = -1;
            if (this.root != null) {
                num = this.root.value;
                this.root = this.root.next;
                this.size--;
            }


            return num;
        }

        int peek() {
            if (this.root != null) {
                return this.root.value;
            }
            return -1;
        }

        boolean isEmpty() {
            return this.size == 0;
        }
    }

    static class Node{
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
