package org.spiral;

public class Sort {
   public static void sort(int[] arr){
       for (int i = 0; i < arr.length; i+=3) {
           for (int j = 0; j < arr.length-3; j += 3) {
               if (arr[j] > arr[j + 3]) {
                   int h1 = arr[j + 3];
                   int h2 = arr[j + 4];
                   int h3 = arr[j + 5];
                   arr[j + 3] = arr[j];
                   arr[j + 4] = arr[j + 1];
                   arr[j + 5] = arr[j + 2];
                   arr[j] = h1;
                   arr[j + 1] = h2;
                   arr[j + 2] = h3;
               }
           }
       }
       int[] sortedFibonacci = new int[arr.length];
       int cnt=0;
       for (int i = 0; i < arr.length-3; i+=3) {
           if(arr[i]<arr[i+3]){
               sortedFibonacci[cnt]=arr[i];
               cnt++;
           }
           else{
               sortedFibonacci[cnt]=arr[i+3];
               break;
           }
       }
   }



   public static int[] devideTheFibNumbersInFibSequences(int[] nums) {
       int[] h = new int[nums.length];
       for (int i = 0; i < nums.length -2; i+=3) {
           h[i] = nums[i];
       }

       for (int i = 0; i < nums.length - 3; i+=3) {
           if (nums[i] == nums[i+3])
           {
               int helper = nums[i +3];
               int helper1 = nums[i +4];
               int helper2 = nums[i +5];
               for (int j = i + 3; j < nums.length - 2; j+=3) {

                   if (j == nums.length - 3) {
                       nums[j] = helper;
                       nums[j +1] = helper1;
                       nums[j +2] = helper2;
                       break;
                   }
                   nums[j] = nums[j + 3];
                   nums[j+1] = nums[j + 4];
                   nums[j+2] = nums[j + 5];
               }
           }
       }

       //Checks if the array had undergone changes, if not return nums
       boolean isSameArray = false;
       for (int i = 0; i < nums.length -2; i+=3) {
           if (nums[i] == h[i]) {
               isSameArray = true;
           }
           else {
               isSameArray = false;
               break;
           }
       }

       if (isSameArray) {
           return nums;
       }
       //Checks if the array is sorted Example: 1 2 3 4 5 1 2 3 4 5 6 7 1 2 3 -> returns true
       boolean isTheArrayProperlySorted = false;
       for (int i = 0; i < nums.length - 3; i+=3) {

           if (nums[i] != nums[i+3]) {
               isTheArrayProperlySorted = true;
           }
           else {
               isTheArrayProperlySorted = false;
               break;
           }
       }

       if (isTheArrayProperlySorted) {
           return nums;
       }
       return devideTheFibNumbersInFibSequences(nums);
   }
}
