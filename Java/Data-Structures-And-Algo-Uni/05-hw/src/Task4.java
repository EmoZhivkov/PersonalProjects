import java.util.LinkedList;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = scanner.nextLong();

        LinkedList<Long> queue = new LinkedList<>();
        if (num <= 10) {
            for (long i = 1; i <= 9; i++) {
                if (i <= num) {
                    System.out.print(i + " ");
                }
            }
            return;
        } else {
            for (long i = 1; i <= 9; i++) {
                queue.addLast(i);
            }
        }


        long current = queue.pop();

        while (current < num) {

            System.out.print(current + " ");

            long lastDigit = current % 10;

            if (lastDigit - 2 >= 0) {
                queue.addLast((current*10) + (lastDigit - 2));
            }

            if (lastDigit + 2 <= 9) {
                queue.addLast((current*10) + (lastDigit + 2));
            }

            current = queue.pop();
        }
    }

}
