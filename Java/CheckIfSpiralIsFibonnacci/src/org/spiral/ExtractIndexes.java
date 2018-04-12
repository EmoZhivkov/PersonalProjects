package org.spiral;

public class ExtractIndexes {
    public static int[] extractNumbers(int[] arr){
        int[] numbers = new int[arr.length/3];
        int cnt = 0;
        for (int i = 0; i < arr.length; i+=3) {
            numbers[cnt]=arr[i];
            cnt++;
        }
        return numbers;
    }
    public static int[] extractLeft(int[] arr){
        int[] numbers = new int[arr.length/3];
        int cnt = 0;
        for (int i = 1; i < arr.length; i+=3) {
            numbers[cnt]=arr[i];
            cnt++;
        }
        return numbers;
    }
    public static int[] extractRight(int[] arr){
        int[] numbers = new int[arr.length/3];
        int cnt = 0;
        for (int i = 2; i < arr.length; i+=3) {
            numbers[cnt]=arr[i];
            cnt++;
        }
        return numbers;
    }



}
