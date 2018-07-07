# Test-by-Uber

import java.util.*;
public class TeamSelection {
    public static int teamFormation(int[] array, int team, int m, int score) {
        if (team == 0) return score;
        int maxIndex = 0;
        if (m < array.length) {
            for (int i = 0; i < m; i++) {
                if (array[i] >= array[maxIndex]) maxIndex = i;
            }
            for (int i = array.length - m; i < array.length; i++) {
                if (array[i] >= array[maxIndex]) maxIndex = i;
            }
        }
        if(m>array.length)
        {
            for (int i = 0; i < array.length; i++) {
                if (array[i] >= array[maxIndex]) maxIndex = i;
            }
        }
        int[] reducedArray = new int[array.length-1];
        int index = 0;
        for(int i=0;i<array.length-1;i++) {
            if (i == maxIndex) index++;
            reducedArray[i] = array[index];
            index++;
        }
        score+=array[maxIndex];
        return teamFormation(reducedArray, team-1,m,score);
    }
}
