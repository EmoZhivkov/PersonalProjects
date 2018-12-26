import java.util.*;

public class Google {
    static int solution(int[] s, int[] e) {
        int chairs = 0;
        int maxChairs = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length; i++) {
            map.put(s[i], e[i]);
        }

        Arrays.sort(s);

        Set<Integer> setLeave = new HashSet<>();

        for (int i = 1; i <= 1000; i++) {
            if (map.containsKey(i)) {
                setLeave.add(map.get(i));

                chairs++;
                if (chairs > maxChairs) {
                    maxChairs = chairs;
                }
            }

            if (setLeave.contains(i)) {
                chairs--;
            }


        }

        return maxChairs - 1;
    }

    public static void main(String[] args) {
        int[] s = {1,2,6,5,3};
        int[] e = {5,5,7,6,8};

        System.out.println(solution(s, e));
    }
}
