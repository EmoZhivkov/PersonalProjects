import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Task1 {
    static ArrayList<ArrayList<Pair<Integer, Long>>> adj;
    static ArrayList<Long> distances;
    static ArrayList<Boolean> visited;

    static void dijkstra(int s) {
        distances.set(s, 0L);

        for (int i = 1; i < adj.size(); i++) {
            int v = -1;
            for (int j = 1; j < adj.size(); j++) {
                if (!visited.get(j) && (v == -1 || distances.get(j) < distances.get(v))) {
                    v = j;
                }
            }

            if (distances.get(v) == Long.MAX_VALUE) {
                break;
            }

            visited.set(v, true);

            for (Pair<Integer, Long> edge :
                    adj.get(v)) {
                int to = edge.first;
                long len = edge.second;

                if (distances.get(v) + len < distances.get(to)) {
                    distances.set(to, distances.get(v) + len);
                }
            }
        }
    }

    public static void main(String[] args) {
        InputReader scanner = new InputReader();

        int lenght = scanner.readInt();
        for (int k = 0; k < lenght; k++) {


            int vertices = scanner.readInt();
            adj = new ArrayList<>(vertices + 1);
            distances = new ArrayList<>(vertices + 1);
            visited = new ArrayList<>(vertices + 1);

            for (int i = 0; i < vertices + 1; i++) {
                adj.add(new ArrayList<Pair<Integer, Long>>());
                distances.add(Long.MAX_VALUE);
                visited.add(false);
            }

            int edges = scanner.readInt();
            for (int i = 0; i < edges; i++) {
                int currentVertex = scanner.readInt();
                int nextVertex = scanner.readInt();
                long weight = scanner.readLong();

                adj.get(currentVertex).add(Pair.create(nextVertex, weight));
                adj.get(nextVertex).add(Pair.create(currentVertex, weight));
            }

            int s = scanner.readInt();

            dijkstra(s);

            for (int i = 1; i <= vertices; i++) {
                if (i == s) {
                    continue;
                }

                long distance = distances.get(i);
                if (distance == Long.MAX_VALUE) {
                    System.out.print(-1 + " ");
                    continue;
                }

                System.out.print(distance + " ");
            }
            System.out.println();
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        InputReader() {
            this.stream = System.in;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        double readDouble() throws InputMismatchException {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.' && c != ',') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.' || c == ',') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        String readLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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
