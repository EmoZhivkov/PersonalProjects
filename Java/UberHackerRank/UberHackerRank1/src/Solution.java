import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static List<Integer> getMinimumBlows(int[] height) {
        Queue<List<Integer>> right = new LinkedList<>();
        Queue<List<Integer>> left = new LinkedList<>();

        List<Integer> temp = new ArrayList<>();
        temp.add(height[0]);
        for (int i = 0; i < height.length - 1; i++) {

            if (height[i] < height[i + 1]) {
                temp.add(height[i + 1]);
            } else {
                return temp;
                /*right.add(temp);
                temp.clear();
                temp.add(height[i + 1]);*/
            }

        }
        right.add(temp);
        temp.clear();

        temp.add(height[height.length - 1]);
        for (int i = height.length - 1; i > 0; i--) {
            if (height[i] < height[i - 1]) {
                temp.add(height[i - 1]);
            } else {
                left.add(temp);
                temp.clear();
                temp.add(height[i - 1]);
            }
        }
        left.add(temp);

        int cnt = 0;
        int arrLength = height.length;
        while (arrLength > 0) {
            int r, l;

            try {
                r = right.peek().size();
            } catch (NullPointerException e) {
                r = 0;
            }

            try {
                l = left.peek().size();
            } catch (NullPointerException e) {
                l = 0;
            }

            if (r >= l) {
                arrLength -= r;
                if (arrLength < 0) {
                    arrLength += r;
                    arrLength -= l;
                    left.poll();
                } else {
                    right.poll();
                }
            } else {
                arrLength -= l;
                if (arrLength < 0) {
                    arrLength += l;
                    arrLength -= r;
                    right.poll();
                } else {
                    left.poll();
                }
            }
            cnt++;
        }
        return null;
    }
}
