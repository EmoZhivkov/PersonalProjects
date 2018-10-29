import java.util.Scanner;

public class Third {
    static long answer = 0;

    static long binarySearch(long k, long arr[], int l, int r) {
        int mid = (l + r)/2;
        if (r >= l) {
            if (isPossible(arr, mid, k)) {
                answer = mid;
                return binarySearch(k, arr, l, mid - 1);
            } else {
                return binarySearch(k, arr, mid + 1, r);
            }
        }

        return answer;
    }

    static boolean isPossible(long[] arr, int t, long k) {
        int helper = t;
        for (int i = 0; i < arr.length; i++) {
            long currentEl = arr[i];
            if (currentEl > t) {
                currentEl -= t;

                long mult =  (currentEl + (k - 1) - 1) / (k - 1);

                helper -= mult;

                if (helper < 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenght = scanner.nextInt();
        long k = scanner.nextLong();

        long[] arr = new long[lenght];
        for (int i = 0; i < lenght; i++) {
            arr[i] = scanner.nextLong();
        }

        if (k == 1) {
            long biggest = arr[0];

            for (int i = 1; i < lenght; i++) {
                if (biggest < arr[i]) {
                    biggest = arr[i];
                }
            }

            System.out.println(biggest);
        } else {
            System.out.println(binarySearch(k, arr, 0, 1000000000));
        }

    }
}