import java.sql.Time;
import java.util.Arrays;
import java.util.Scanner;

public class Second {
    public static int binarySearchLast (long[] arr, int l, int r, long key){
        while(l < r){
            int mid = l + ((r - l) +1) / 2;

            if(arr[mid] <= key){
                l = mid;
            }
            else{
                r = mid-1;
            }
        }

        if (arr[l] == key) {
            return l + 1;
        }

        return -1;
    }

    static int binarySearchFirst(long arr[], int l, int r, long key) {
        while(l < r){
            int mid = l + (r - l) / 2;

            if(arr[mid] >= key){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }

        if (arr[l] == key) {
            return l + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenght = scanner.nextInt();

        long[] arr = new long[lenght];
        for (int i = 0; i < lenght; i++) {
            arr[i] = scanner.nextLong();
        }

        Arrays.sort(arr);

        int numOfRequests = scanner.nextInt();

        long[] requests = new long[numOfRequests];
        for (int i = 0; i < numOfRequests; i++) {
            requests[i] = scanner.nextLong();
        }

        for (int i = 0; i < numOfRequests; i++) {
            System.out.println(binarySearchFirst(arr, 0, lenght - 1, requests[i]) + " " + binarySearchLast(arr, 0, lenght - 1, requests[i]));
        }
    }
}
