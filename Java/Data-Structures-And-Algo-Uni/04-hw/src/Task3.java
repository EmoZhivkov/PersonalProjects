import java.util.*;

public class Task3 {
    static class Node{
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        Node[] balls = new Node[length + 1];
        balls[0] = new Node(0, null);

        int[] arr = new int[length + 1];
        arr[0] = 0;
        long sum = 0;

        for (int i = 1; i <= length; i++) {
            int p = scanner.nextInt();
            int m = scanner.nextInt();

            if (m != 0) {
                balls[i] = new Node(m, balls[p]);

                arr[i] = arr[p] + m;
                sum += arr[i];
            } else {
                balls[i] = balls[p].next;

                arr[i] = arr[p] - balls[p].value;
                sum += arr[i];
            }
        }

        System.out.println(sum);
    }
}
