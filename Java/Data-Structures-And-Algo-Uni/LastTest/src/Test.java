import java.util.*;

public class Test {
    static int currentCnt = 0;
    static int currentWeight = 0;
    static int numOfEdges = 0;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();

        Graph graph = new Graph(v + 1);

        for (int i = 0; i < e; i++) {
            int from = scanner.nextInt();
            int to  = scanner.nextInt();
            int weight = scanner.nextInt();

            graph.addEdge(from, to, weight);
        }

        int edges = scanner.nextInt();
        numOfEdges = edges;

        for (int i = 0; i <= v; i++) {
            graph.DFS(i);
        }

        int biggest = 0;

        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            if (entry.getValue() > biggest) {
                biggest = entry.getValue();
            }
        }

        System.out.println(biggest);

    }

    static class Edge {
        int to;
        int weight;


        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Graph {
        int V;
        LinkedList<Edge> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w, int weight) {
            adj[v].add(new Edge(w, weight));
        }

        void BFS(int s) {
            boolean visited[] = new boolean[V];

            LinkedList<Integer> queue = new LinkedList<Integer>();

            visited[s] = true;
            queue.add(s);

            while (queue.size() != 0) {
                s = queue.poll();
                System.out.print(s + " ");

                Iterator<Edge> i = adj[s].listIterator();
                while (i.hasNext()) {
                    Edge edge = i.next();
                    if (!visited[edge.to]) {
                        visited[edge.to] = true;
                        queue.add(edge.to);
                    }
                }
            }
        }

        void DFSUtil(int v, boolean visited[]) {
            visited[v] = true;

            Iterator<Edge> i = adj[v].listIterator();
            while (i.hasNext()) {
                Edge edge = i.next();
                if (!visited[edge.to]) {
                    currentCnt++;
                    currentWeight += edge.weight;

                    if (currentCnt == numOfEdges) {
                        currentCnt = 0;

                        if (!map.containsKey(currentWeight)) {
                            map.put(currentWeight, 1);
                        } else {
                            map.put(currentWeight, map.get(currentWeight) + 1);
                        }
                        currentWeight = 0;
                        break;
                    }

                    DFSUtil(edge.to, visited);
                }
            }
        }

        void DFS(int v) {
            boolean visited[] = new boolean[V];

            DFSUtil(v, visited);
        }
    }
}
