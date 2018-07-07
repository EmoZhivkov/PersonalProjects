import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,2,3,2,1};
        List<Integer> temp = Solution.getMinimumBlows(arr);
        while (!temp.isEmpty()) {
            for (int i = 0; i < temp.size(); i++) {
                System.out.println(temp.get(i));
            }
            System.out.println("/////////////////////");
        }
    }
}
