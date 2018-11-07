import java.util.*;

public class Task2 {

    static class LinkedList {
        Node root;
        int size;

        LinkedList() {
            this.root = null;
            this.size = 0;
        }

        void insert(int value) {
            root = new Node(value, root);
            size++;
        }

        int get() {
            if (size == 0) {
                return -1;
            }

            int num = this.root.value;
            this.root = this.root.next;
            size--;

            return num;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    static class Node{
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstLen = scanner.nextInt();
        LinkedList list = new LinkedList();

        for (int i = 0; i < firstLen; i++) {
            list.insert(scanner.nextInt());
        }

        Set<Integer> set = new HashSet<>();
        int secondLen = scanner.nextInt();

        for (int i = 0; i < secondLen; i++) {
            set.add(scanner.nextInt());
        }

        Set<Pair<Integer, Integer>> pairs = new HashSet<>();
        int first = list.get();
        int second = list.get();

        if (first == -1 || second == -1) {
            System.out.println(0);
            return;
        }

        if (set.contains(first) && set.contains(second)) {
            Pair<Integer, Integer> pair = new Pair<>(first, second);
            pairs.add(pair);
        }

        int temp = second;
        while (!list.isEmpty()) {
            first = temp;
            second = list.get();

            temp = second;

            if (!set.contains(first) || !set.contains(second)) {
                continue;
            }

            Pair<Integer, Integer> current = new Pair<>(first, second);
            pairs.add(current);
        }

        System.out.println(pairs.size());
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

            if (Objects.equals(p.first, second) && Objects.equals(p.second, first)) {
                return true;
            }

            return Objects.equals(p.first, first) && Objects.equals(p.second, second);
        }

        @Override
        public int hashCode() {
            return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
        }

        public static <A, B> Pair <A, B> create(A a, B b) {
            return new Pair<A, B>(a, b);
        }
    }
}
