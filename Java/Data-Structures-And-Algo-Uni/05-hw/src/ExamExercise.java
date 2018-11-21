import com.sun.org.apache.bcel.internal.generic.VariableLengthInstruction;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.List;

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

        void group(int posX, int posY) {
            if (posX > posY || posX < 0 || posY < 0 || posX >= this.size || posY >= this.size) {
                System.out.print("fail_grouping");
                return;
            }

            int currPos = 0;

            int sum = 0;
            if (currPos == posX) {
                sum += this.root.value;

                Node prev = this.root;
                Node current = this.root;


                while (currPos != posY) {
                    current = current.getNext();
                    sum += current.value;

                    currPos++;
                }

                Node temp = new Node(sum);
                this.root = current.next;
                temp.next = this.root;
                this.root = temp;

            } else  {
                Node prev = null;
                Node current = this.root;

                while (current.hasNext()) {
                    prev = current;
                    current = current.getNext();
                    currPos++;
                    if (currPos == posX) {
                        sum += current.value;
                        while (currPos != posY) {
                            current = current.getNext();
                            sum += current.value;
                            currPos++;
                        }
                        break;
                    }
                }



                Node temp = new Node(sum);
                prev.next = temp;
                temp.next = current.next;


            }
        }

        void removeAll(int X){
            if (this.root == null) {
                return;
            }

            Node temp = this.root;
            Node prev = null;

            while (temp.hasNext()) {
                prev = temp;
                temp = temp.getNext();

                if (temp.value == X) {
                    prev.next = temp.getNext();
                    temp = prev;

                    this.size--;
                }
            }

            if (this.root.value == X) {
                this.root = this.root.next;
            }
        }



        void is_palindrom() {
            int[] arr = new int[this.size];

            if (this.root == null) {
                System.out.print("true");
                return;
            }

            Node temp = this.root;

            int cnt = 0;
            arr[cnt] = temp.value;
            cnt++;

            while (temp.hasNext()) {
                temp = temp.getNext();
                arr[cnt] = temp.value;
                cnt++;
            }

            for (int i = 0, j = this.size - 1; i < this.size && j >= 0; i++, j--) {
                if (arr[i] != arr[j]) {
                    System.out.print("false");
                    return;
                }
            }

            System.out.print("true");
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
                this.root = this.tail = temp;
                this.size++;

                if (pos != 0) {
                    System.out.print("add_last");
                }

                return;
            }

            if (pos == 0) {
                temp.next = this.root;
                this.root = temp;
                this.size++;

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


            if (this.size == pos) {
                this.size++;
                return;
            }

            this.size++;
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

        boolean isEmpty() {
            return this.size == 0;
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
        linkedList.insertAtPosition(2, 2);
        linkedList.insertAtPosition(1, 3);



        linkedList.group(0, 1);


//      System.out.println("////" +linkedList.size+ "///")
//      linkedList.remove(1);
//      System.out.println(linkedList.size);

        linkedList.print();
    }
}
