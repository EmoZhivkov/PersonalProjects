import com.sun.org.apache.bcel.internal.generic.VariableLengthInstruction;

public class ExamExercise {
    static class LinkedList {
        Node root;
        Node tail;

        LinkedList() {
            this.root = this.tail = null;
        }

        void insertAtBack(int value) {
            Node temp = new Node(value);

            if (this.tail == null) {
                this.root = this.tail = temp;
                return;
            }

            this.tail.next = temp;
            this.tail = temp;
        }

        void insertAtFront(int value) {
            Node temp = new Node(value);

            temp.next = this.root;
            this.root = temp;
        }

        int getBack() {
            Node current = this.root;
            Node prev = null;

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

            this.root = this.root.next;

            return num;
        }

        void print() {
            Node temp = root;
            System.out.println(this.root.value);

            while (temp.hasNext()) {
                temp = temp.getNext();
                System.out.println(temp.value);
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
    }

//    static class LinkedList{
//        Node root;
//        Node tail;
//
//        LinkedList() {
//            this.root = null;
//            this.tail = null;
//        }
//
//        void insertAtBack(int value) {
//            Node temp = new Node(value);
//
//
//            if (this.root == null) {
//                this.root = temp;
//                this.tail = temp;
//                return;
//            }
//
//            this.tail.next = temp;
//            this.tail = temp;
//        }
//
//        void insertAtRoot(int value) {
//            Node temp = new Node(value);
//
//            if (this.root == null) {
//                this.root = temp;
//                this.tail = temp;
//                return;
//            }
//
//            temp.next = this.root;
//            this.root = temp;
//        }
//
//        int getBack() {
//            Node current = this.root;
//            Node prev = null;
//
//            while (current.hasNext()) {
//                prev = current;
//                current = current.getNext();
//            }
//
//            prev.next = null;
//            this.tail = prev;
//
//            return  current.value;
//        }
//
//        int getFront() {
//            int num = this.root.value;
//
//            this.root = this.root.next;
//
//            return num;
//        }
//
//        void print() {
//            Node temp = this.root;
//            System.out.println(temp.value);
//            while (temp.hasNext()) {
//                temp = temp.getNext();
//                System.out.println(temp.value);
//            }
//        }
//
//        class Node {
//            int value;
//            Node next;
//
//            Node(int value) {
//                this.next = null;
//                this.value = value;
//            }
//
//            Node getNext() {
//                return this.next;
//            }
//
//            boolean hasNext() {
//                return this.next != null;
//            }
//        }
//    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertAtBack(1);
        linkedList.insertAtBack(2);
        linkedList.insertAtBack(3);
        linkedList.insertAtBack(4);

        linkedList.reverse();

        linkedList.print();
    }
}
