import com.sun.org.apache.bcel.internal.generic.VariableLengthInstruction;

public class ExamExercise {
    static class LinkedList {
        class Node {
            Node next;
            int value;

            Node(int value) {
                this.next = null;
                this.value = value;
            }

            boolean hasNext() {
                return this.next != null;
            }

            Node getNext() {
                return this.next;
            }
        }

        Node root;
        Node tail;
        int size;

        LinkedList() {
            this.root = this.tail = null;
            this.size = 0;
        }

        void remove(int pos) {
            if (pos < 0 || pos > this.size - 1) {
                System.out.print("remove_failed");
                return;
            }

            if (pos == 0) {
                this.getFront();
                return;
            } else if (pos == size - 1) {
                this.getBack();
                return;
            }

            Node current = this.root;
            Node prev = null;

            int cnt = 0;

            while (current.hasNext()) {
                prev = current;
                current = current.getNext();
                cnt++;

                if (cnt == pos) {
                    prev.next = current.next;
                    this.size--;
                }
            }

        }

        void insertAtPosition(int value, int pos) {
            Node temp = new Node(value);

            if (this.root == null) {
                if (pos != 0) {
                    this.root = this.tail = temp;
                    this.size++;
                    System.out.print("add_last");
                    return;
                } else {
                    this.root = this.tail = temp;
                    this.size++;
                    return;
                }
            }

            if (pos == 0) {
                this.insertAtFront(value);
                return;
            } else if (pos == this.size) {
                this.insertAtBack(value);
                return;
            }

            Node current = this.root;
            Node prev = null;

            int cnt = 0;

            while (current.hasNext()) {
                prev = current;
                current = current.getNext();
                cnt++;

                if (cnt == pos) {
                    prev.next = temp;
                    temp.next = current;
                    this.size++;
                    return;
                }
            }

            current.next = temp;
            if (cnt  == pos - 1) {
                return;
            }
            System.out.print("add_last");
        }

        void insertAtBack(int value) {
            Node temp = new Node(value);
            this.size++;

            if (this.tail == null) {
                this.root = this.tail = temp;
                return;
            }

            this.tail.next = temp;
            this.tail = temp;
        }

        void insertAtFront(int value) {
            this.size++;
            Node temp = new Node(value);

            temp.next = this.root;
            this.root = temp;
        }

        int getBack() {
            Node current = this.root;
            Node prev = null;
            this.size--;

            while (current.hasNext()) {
                prev = current;
                current = current.getNext();
            }

            prev.next = null;
            this.tail = prev;

            return current.value;
        }

        int getFront() {
            int num = this.root.value;
            this.size--;

            this.root = this.root.next;

            return num;
        }

        void print() {
            if (this.root == null) {
                return;
            }
            Node temp = root;
            System.out.print(this.root.value + "#");

            while (temp.hasNext()) {
                temp = temp.getNext();
                System.out.print(temp.value + "#");
            }
        }

        void reverse() {
            Node current = this.root;
            Node prev = null;
            Node next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            this.root = prev;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();


        linkedList.insertAtPosition(1, 0);
        linkedList.insertAtPosition(2, 1);
        linkedList.insertAtPosition(3, 1);

//        System.out.println("////" +linkedList.size+ "///");
       linkedList.remove(1);

        linkedList.print();
    }
}
