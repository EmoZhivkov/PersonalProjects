import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstKid = scanner.nextInt();
        int len = scanner.nextInt();

        Set<Integer> set = new HashSet<>();
        set.add(firstKid);

        for (int i = 0; i < len; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();

            if (set.contains(first)) {
                set.add(second);
            }
        }

        System.out.println(set.size());
    }
}
