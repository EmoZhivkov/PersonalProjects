package org.spiral;

public class AreThereFibSpirals {
    public static boolean answer(int[] arr, int pointer, int matrixSize) {
        int h = pointer;
        boolean a = true;
        for (int i = h; i < arr.length - 3; i+= 3) {
            if (arr[i] < arr[i + 3]){
                pointer+=3;
            }
            else {
                break;
            }
        }
        
        pointer+=3;
        int[] fibSpiral = new int[pointer];
        for (int i = 0; i < fibSpiral.length; i++) {
            fibSpiral[i] = arr[i];
        }
        int[] nums = ExtractIndexes.extractNumbers(fibSpiral);
        int[] left = ExtractIndexes.extractLeft(fibSpiral);
        int[] right = ExtractIndexes.extractRight(fibSpiral);

        for (int i = 0; i < left.length; i++) {
            int arrLength = i +1;
            int[] leftHelper = new int[arrLength];
            int[] rightHelper = new int[arrLength];
            for (int j = 0; j < arrLength; j++) {
                leftHelper[j] = left[j];
                rightHelper[j] = right[j];
            }
            a = Traversal.isFibIndexesSpiral(leftHelper, rightHelper, 3);
            if (a) {
                return true;
            }
        }


        if (pointer == arr.length) {
            return false;
        }
        return answer(arr, pointer, 3);
    }
}
