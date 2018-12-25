import java.util.*;

class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long q = Long.parseLong(scanner.nextLine());

        while (q-- > 0) {
            String data[] = scanner.nextLine().split(" ");

            int n = Integer.parseInt(data[0]);
            int m = Integer.parseInt(data[1]);

            int distance[] = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                distance[i] = -1;
            }

            int init = 0;
            int wait = 1;
            int visited = 2;
            int state[] = new int[n + 1];
            int adj[][] = new int[n + 1][n + 1];

            for (int i = 0; i < m; i++) {
                data = scanner.nextLine().split(" ");

                adj[Integer.parseInt(data[0])][Integer.parseInt(data[1])] = 1;
                adj[Integer.parseInt(data[1])][Integer.parseInt(data[0])] = 1;
            }

            int s = Integer.parseInt(scanner.nextLine());

            LinkedList queue = new LinkedList();
            queue.add(s);

            while (queue.size() != 0) {
                int temp = (int) queue.remove(0);
                state[temp] = visited;

                for (int i = 1; i < n + 1; i++) {
                    if (adj[temp][i] == 1 && state[i] == init) {
                        queue.add(i);

                        state[i] = wait;

                        if (distance[temp] == -1) {
                            distance[i] = 6;
                        } else {
                            distance[i] = distance[temp] + 6;
                        }
                    }
                }
            }

            for (int i = 1; i < n + 1; i++) {
                if (i != s) {
                    System.out.print(distance[i] + " ");
                }
            }

            if (q != -1) {
                System.out.println();
            }
        }
    }
}