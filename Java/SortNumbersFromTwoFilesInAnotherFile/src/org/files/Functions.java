package org.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Functions {
    public static int[] extractIntArrayFromFile(String fileName, int howManyNumbers) {
        int intOfChar = 0;
        String currentNum = new String();

        char currentChar = 0;
        int cnt = 0;
        int[] numsInFirst = new int[howManyNumbers];
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader firstBuff = new BufferedReader(fileReader);
            do{
                intOfChar = firstBuff.read();
                if (intOfChar == 44){
                    numsInFirst[cnt] = Integer.parseInt(currentNum);
                    currentNum = "";
                    cnt++;
                }
                else if (intOfChar == -1){
                    numsInFirst[cnt] = Integer.parseInt(currentNum);
                    cnt++;
                }
                else{
                    currentChar = (char)intOfChar;
                    currentNum = currentNum + currentChar;
                }
            }while (intOfChar != -1);
        }
        catch (FileNotFoundException ex) {
            System.out.println("Unable to open the file.");
        }
        catch (IOException ex){
            System.out.println("Unable to read.");
        }

        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = numsInFirst[i];
        }
        return arr;
    }

    public static int[] combineTwoIntArrays(int[] arr1, int[] arr2) {
        int[] finalArr = new int[arr1.length + arr2.length];
        int i;
        int j = 0;
        int k = 0;
        for (i = 0; i < finalArr.length; i++) {
            if (i < arr1.length) {
                finalArr[i] = arr1[j];
                j++;
            }
            else {
                finalArr[i] = arr2[k];
                k++;
            }
        }
        return finalArr;
    }
}
