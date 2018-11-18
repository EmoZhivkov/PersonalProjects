import java.util.*;

public class Task3 {
    static int row = 0;
    static int col = 0;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object p) {
            Point curr = (Point) p;

            return (curr.x == this.x) && (curr.y == this.y);
        }
    }

    static class QueueNode {
        Point point;
        int dist;

        QueueNode(Point point, int dist) {
            this.point = point;
            this.dist = dist;
        }
    }

    static boolean isValidAndNotVisited(Point point, boolean[][] visited, short[][] matrix) {
        return point.x >= 0 && point.x < row && point.y >= 0 && point.y < col && !visited[point.x][point.y] && matrix[point.x][point.y] == 0;
    }

    static int bfs(short[][] matrix, Point dest) {
        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;

        LinkedList<QueueNode> nodes = new LinkedList<>();
        nodes.addLast(new QueueNode(new Point(0,0), 0));

        while (!nodes.isEmpty()) {
            QueueNode current = nodes.pop();

            if (current.point.equals(dest)) {
                return current.dist;
            }

            List<Point> sides = new ArrayList<>();
            Point left = new Point(current.point.x, current.point.y -1);
            sides.add(left);

            Point top = new Point(current.point.x - 1, current.point.y);
            sides.add(top);

            Point right = new Point(current.point.x, current.point.y + 1);
            sides.add(right);

            Point bot = new Point(current.point.x + 1, current.point.y);
            sides.add(bot);

            for (Point p :
                    sides) {
                if (isValidAndNotVisited(p, visited, matrix)) {
                    nodes.addLast(new QueueNode(p, current.dist + 1));
                    visited[p.x][p.y] = true;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        int requests = scanner.nextInt();

        short[][] matrix = new short[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = scanner.nextShort();
            }
        }

        Point[] points = new Point[requests];

        for (int i = 0; i < requests; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }

        for (Point p :
                points) {
            System.out.println(bfs(matrix, p));
        }

    }
}
