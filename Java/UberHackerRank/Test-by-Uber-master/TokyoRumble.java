# Test-by-Uber

public class TokyoRumble {
    public static int getMinimumBlows(int[] height, int steps) {
        int counterLeft=1;
        int counterRight = 1;
        for (int i = 0; i < height.length; i++) {
            if(i+1< height.length) {
                if (height[i + 1] == height[i] + 1) counterLeft++;
                else {
                    i = height.length;
                }
            }
        }
        for (int i = 0; i < height.length; i++) {
            if(i+1< height.length) {
                if (height[i + 1] == height[i] - 1) counterRight++;
                else {
                    i = height.length;
                }
            }
        }
        int biggerCounter = (counterLeft>counterRight) ? counterLeft : counterRight;
        steps++;
        if(height.length-biggerCounter==0)return steps;
        int[] reducedHeight = new int[height.length - biggerCounter];
        for (int i = 0; i < reducedHeight.length ; i++){
            reducedHeight[i] = height[biggerCounter];
            biggerCounter++;
        }

        return getMinimumBlows(reducedHeight, steps);
    }
}
