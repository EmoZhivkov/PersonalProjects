package org.files;

public class Main {
    public static void main(String[] args) {

        int[] numsFromFirst = Functions.extractIntArrayFromFile("first.txt", 100);
        int[] numsFromSecond = Functions.extractIntArrayFromFile("second.txt", 100);

        int[] combined = Functions.combineTwoIntArrays(numsFromFirst, numsFromSecond);
        MergeSort.mergeSort(combined, 0, combined.length - 1);

        for (int i = 0; i < combined.length; i++) {
            System.out.print(combined[i] + " ");
        }
    }
}
