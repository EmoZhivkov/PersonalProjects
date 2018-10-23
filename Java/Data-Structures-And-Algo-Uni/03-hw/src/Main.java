import java.sql.Time;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static long binarySearchLast (long[] a, int l, int r, long key){

        while(l < r){
            int mid = l + ((r - l) +1) / 2;

            if(a[mid] <= key){
                l = mid;
            }
            else{
                r = mid-1;
            }
        }

        if (a[l] == key) {
            return l;
        }

        return -1;
    }


    static int binarySearch(long arr[], int l, int r, long x) {
        if (r>=l) {
            int mid = l + (r - l)/2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            }

            return binarySearch(arr, mid+1, r, x);
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
            System.out.println(binarySearch(arr, 0, lenght, requests[i]) + " " + binarySearchLast(arr, 0, lenght, requests[i]));
        }



//        Scanner scanner = new Scanner(System.in);
//
//        int numOfCases = scanner.nextInt();
//
//        int[] arr = new int[numOfCases];
//
//        long start = java.lang.System.currentTimeMillis();
//
//        for (int i = 0; i < numOfCases; i++) {
//            int num = scanner.nextInt();
//            int cnt = 0;
//
//            while (num != 0) {
//                num = num >> 1;
//                cnt++;
//            }
//
//            arr[i] = cnt;
//        }
//
//        for (int i = 0; i < numOfCases; i++) {
//            System.out.println(arr[i]);
//        }
//
//        System.out.println(java.lang.System.currentTimeMillis() - start);
    }
}
