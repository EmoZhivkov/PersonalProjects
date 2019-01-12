import java.util.*;

public class Test {

    static List<Edge>[] adj;
    static boolean[] visited;
    static int[] dist;
    static int[] pred;


    static void dijkstra(int start) {
        dist[start] = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>(); // (x,y) -> y-x
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.remove();

            if (visited[cur])
                continue;

            visited[cur] = true;

// tuka trqq da ima za result

            for (Edge e : adj[cur]) {
                int v = e.t;
                int currentDist = dist[cur] + e.cost;

                if (dist[v] > currentDist) { // Diikstra
                    dist[v] = currentDist;
                    pred[v] = cur;
                    q.add(v);
                }

//                if (!visited[v] && dist[v] > e.cost) { //MST Prim
//                    dist[v] = e.cost;
//                    pred[v] = cur;
//                    q.add(v);
//                }
            }
        }
    }

    static class Edge {
        int t;
        int cost;

        Edge(int t, int cost) {
            this.t = t;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vertices = 4;
        int edges = 5;

        adj = new ArrayList[vertices + 1];
        visited = new boolean[vertices + 1];
        dist = new int[vertices + 1];
        pred = new int[vertices + 1];

        for (int i = 1; i < vertices + 1; i++) {
            adj[i] = new ArrayList<>();
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        for (int i = 0; i < edges; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            int weight = scanner.nextInt();

            adj[first].add(new Edge(second, weight));
            adj[second].add(new Edge(first, weight));
        }

        dijkstra(1);

        for (int i = 1; i < vertices + 1; i++) {
            System.out.println("From: " + pred[i] + " to " + i + " distance: " + dist[i]);
        }
    }
}
