import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Task2 {
    static ArrayList<ArrayList<Pair<Integer, Long>>> adj;
    static ArrayList<Long> distances;
    static ArrayList<Boolean> visited;

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

            for (Pair<Integer, Long> e : adj.get(curu)) {
                int v = e.first;

                long nprio = distances.get(curu) + e.second;

                if (distances.get(v) < nprio) {
                    distances.set(v, nprio);
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

        for (int i = 0; i < vertices + 1; i++) {
            adj.add(new ArrayList<Pair<Integer, Long>>());
            distances.add(Long.MIN_VALUE);
            visited.add(false);
        }

        int edges = scanner.nextInt();
        int s = scanner.nextInt();
        int t = scanner.nextInt();

        for (int i = 0; i < edges; i++) {
            int currentVertex = scanner.nextInt();
            int nextVertex = scanner.nextInt();
            long weight = scanner.nextLong();

            adj.get(currentVertex).add(Pair.create(nextVertex, weight));
        }

        betterDijkstra(s);

        long distance = distances.get(t);
        if (distance == Long.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(distance);
        }
    }

    static class Pair<F, S> {
        public final F first;
        public final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair<?, ?> p = (Pair<?, ?>) o;
            return Objects.equals(p.first, first) && Objects.equals(p.second, second);
        }

        @Override
        public int hashCode() {
            return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
        }

        public static <A, B> Pair<A, B> create(A a, B b) {
            return new Pair<A, B>(a, b);
        }
    }
}
