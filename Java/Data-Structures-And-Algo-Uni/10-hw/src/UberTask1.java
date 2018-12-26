import java.util.LinkedList;

public class UberTask1 {
    static int leftEnds = 0;
    static int rightEnds = 0;

    static class Node {
        int value;
        boolean leftEnd;
        boolean rightEnd;

        Node(int value) {
            this.value = value;
            this.leftEnd = false;
            this.rightEnd = false;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,8,7,6,5};
        LinkedList<Node> list = fillUp(arr);
        int cnt = 0;

        while (!list.isEmpty()) {
            Node current;

            if (leftEnds < rightEnds) {
                current = list.removeFirst();

                while (!current.leftEnd) {
                    if (current.rightEnd) {
                        rightEnds--;
                    }

                    if (list.isEmpty()) {
                        break;
                    }

                    current = list.removeFirst();
                }

                leftEnds--;

            } else {
                current = list.removeLast();

                while (!current.rightEnd) {
                    if (current.leftEnd) {
                        leftEnds--;
                    }

                    if (list.isEmpty()) {
                        break;
                    }

                    current = list.removeLast();
                }

                rightEnds--;
            }

            cnt++;

            if (leftEnds == 0 && rightEnds == 0) {
                break;
            }
        }

        System.out.println(cnt);
    }

    static LinkedList<Node> fillUp(int[] arr) {
        LinkedList<Node> linkedList = new LinkedList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            Node current = new Node(arr[i]);

            if (arr[i] > arr[i + 1]) {
                current.leftEnd = true;
                leftEnds++;
            }

            linkedList.addLast(current);
        }

        Node last = new Node(arr[arr.length - 1]);
        last.leftEnd = true;
        leftEnds++;

        linkedList.addLast(last);

        for (int i = arr.length - 1; i > 0; i--) {
            Node current = linkedList.get(i);

            if (arr[i] > arr[i - 1]) {
                current.rightEnd = true;
                rightEnds++;
            }
        }

        Node first = linkedList.get(0);
        first.rightEnd = true;
        rightEnds++;

        return linkedList;
    }
}
