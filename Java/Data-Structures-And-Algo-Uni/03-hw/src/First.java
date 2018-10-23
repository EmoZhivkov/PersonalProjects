import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCases = scanner.nextInt();

        int[] arr = new int[numOfCases];

        long start = java.lang.System.currentTimeMillis();

        for (int i = 0; i < numOfCases; i++) {
            int num = scanner.nextInt();
            int cnt = 0;

            while (num != 0) {
                num = num / 2;
                cnt++;
            }

            arr[i] = cnt;
        }

        for (int i = 0; i < numOfCases; i++) {
            System.out.println(arr[i]);
        }

        System.out.println(java.lang.System.currentTimeMillis() - start);
    }
}
