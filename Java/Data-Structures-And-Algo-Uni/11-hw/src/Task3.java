import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Task3 {
    static ArrayList<ArrayList<Edge>> adj;
    static ArrayList<Long> distances;
    static ArrayList<Boolean> visited;
    static ArrayList<Integer> pred;
    static ArrayList<Edge> predEdge;

    static class Edge {
        int to;
        long weight;
        boolean isRailway;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
            this.isRailway = false;
        }

        Edge(int to, long weight, boolean isRailway) {
            this.to = to;
            this.weight = weight;
            this.isRailway = isRailway;
        }
    }

    static void betterDijkstra(int s) {
        distances.set(s, 0L);

        PriorityQueue<Long> q = new PriorityQueue<>();
        q.add((long) s);

        while (!q.isEmpty()) {
            long cur = q.remove();
            int curu = (int) cur;

            if (cur >>> 32 != distances.get(curu)) {
                continue;
            }

            for (Edge e : adj.get(curu)) {
                int v = e.to;

                long nprio = distances.get(curu) + e.weight;

                if (distances.get(v) >= nprio) {
                    if (distances.get(v) == nprio && e.isRailway)  {
                        continue;
                    }

                    distances.set(v, nprio);
                    pred.set(v, curu);

                    predEdge.set(v, e);

                    q.add((nprio << 32) + v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vertices = scanner.nextInt();
        adj = new ArrayList<>(vertices + 1);
        distances = new ArrayList<>(vertices + 1);
        visited = new ArrayList<>(vertices + 1);
        pred = new ArrayList<>(vertices + 1);
        predEdge = new ArrayList<>(vertices + 1);

        for (int i = 0; i < vertices + 1; i++) {
            adj.add(new ArrayList<Edge>());
            distances.add(Long.MAX_VALUE);
            visited.add(false);
            pred.add(-1);
            predEdge.add(new Edge(-1, 0));
        }

        int edges = scanner.nextInt();
        int railways = scanner.nextInt();

        for (int i = 0; i < edges; i++) {
            int currentVertex = scanner.nextInt();
            int nextVertex = scanner.nextInt();
            long weight = scanner.nextLong();

            adj.get(currentVertex).add(new Edge(nextVertex, weight));
            adj.get(nextVertex).add(new Edge(currentVertex, weight));
        }

        for (int i = 0; i < railways; i++) {
            int to = scanner.nextInt();
            long weight = scanner.nextLong();

            adj.get(1).add(new Edge(to, weight, true));
            adj.get(to).add(new Edge(1, weight, true));
        }

        betterDijkstra(1);

        int cntUsedRailways = 0;
        for (Edge e :
                predEdge) {
            if (e.isRailway) {
                cntUsedRailways++;
            }
        }

        System.out.println(railways - cntUsedRailways);
    }
}
