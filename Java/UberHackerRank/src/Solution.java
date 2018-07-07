import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int getMinimumBlows(int[] height) {
        ArrayList<ArrayList<Integer>> left = new ArrayList<>();
        ArrayList<ArrayList<Integer>> right = new ArrayList<>();

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(height[0]);
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] < height[i + 1]) {
                temp.add(height[i + 1]);
            } else {
                left.add((ArrayList<Integer>) temp.clone());
                temp.clear();
                temp.add(height[i + 1]);
            }
        }
        temp.clear();

        temp.add(height[height.length - 1]);
        for (int i = height.length - 1; i > 0; i--) {
            if (height[i] < height[i - 1]) {
                temp.add(height[i - 1]);
            } else {
                right.add((ArrayList<Integer>) temp.clone());
                temp.clear();
                temp.add(height[i - 1]);
            }
        }
        temp.clear();

        int cntLeft = 0;
        int cntRight = 0;
        int steps = 0;
        int arrLenght = height.length - 1;

        while (true) {
            if (arrLenght <= 1) {
                break;
            }
            int currentLeftSize = 0;
            try {
                currentLeftSize = left.get(cntLeft).size();
            } catch (IndexOutOfBoundsException e) {
                currentLeftSize = 0;
            }

            int currentRightSize = 0;
            try {
                currentRightSize = right.get(cntRight).size();
            } catch (IndexOutOfBoundsException e) {
                currentRightSize = 0;
            }

            if (currentLeftSize == currentRightSize) {
                currentRightSize--;
            }

            if (currentLeftSize > currentRightSize) {
                arrLenght = arrLenght - currentLeftSize;
                cntLeft++;
                if (arrLenght < 0) {
                    arrLenght = arrLenght + currentLeftSize;
                    arrLenght = arrLenght - currentRightSize;
                    cntRight++;
                    cntLeft--;
                }
            } else {
                arrLenght = arrLenght - currentRightSize;
                cntRight++;
                if (arrLenght < 0) {
                    arrLenght = arrLenght + currentRightSize;
                    arrLenght = arrLenght - currentLeftSize;
                    cntLeft++;
                    cntRight--;
                }
            }
            steps++;


        }

        return steps;
    }

    public static int teamFormation(int[] score, int team, int m) {
        int scores = 0;

        while (team != 0) {
            int maxIndex = 0;
            if (m < score.length) {
                for (int i = 0; i < m; i++) {
                    if (score[i] >= score[maxIndex]) {
                        maxIndex = i;
                    }
                }
                for (int i = score.length - m; i < score.length; i++) {
                    if (score[i] >= score[maxIndex]) {
                        maxIndex = i;
                    }
                }
            }

            if (m >= score.length) {
                for (int i = 0; i < score.length; i++) {
                    if (score[i] >= score[maxIndex]) {
                        maxIndex = i;
                    }
                }
            }

            int[] reducedArray = new int[score.length - 1];
            int index = 0;
            for (int i = 0; i < score.length - 1; i++) {
                if (i == maxIndex) {
                    index++;
                }
                reducedArray[i] = score[index];
                index++;
            }

            scores += score[maxIndex];
            score = reducedArray;
            team = team - 1;
        }
        return scores;
    }

    static int programmerStrings(String s) {
        ArrayList<Character> main = new ArrayList<>();
        main.add(0, 'p');
        main.add(1, 'r');
        main.add(2, 'o');
        main.add(3, 'g');
        main.add(4, 'r');
        main.add(5, 'a');
        main.add(6, 'm');
        main.add(7, 'm');
        main.add(8, 'e');
        main.add(9, 'r');


        int leftIndex = 0;
        ArrayList<Character> tempLeft = (ArrayList<Character>) main.clone();
        for (int i = 0; i < s.length(); i++) {
            if (tempLeft.contains(s.charAt(i))) {
                Character a = s.charAt(i);
                tempLeft.remove(a);
            }
            if (tempLeft.isEmpty()) {
                leftIndex = i;
                break;
            }
        }

        int rightIndex = 0;
        ArrayList<Character> tempRight = (ArrayList<Character>) main.clone();
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (tempRight.contains(s.charAt(i))) {
                Character a = s.charAt(i);
                tempRight.remove(a);
            }
            if (tempRight.isEmpty()) {
                rightIndex = i;
                break;
            }
        }
        
        return rightIndex - leftIndex - 1;
    }
}
