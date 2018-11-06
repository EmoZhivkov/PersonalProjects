import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    static class LinkedList {
        Node root;

        LinkedList() {
            this.root = null;
        }

        void insert(int value) {
            root = new Node(value, root);
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
        LinkedList linkedList = new LinkedList();

        InputReader reader = new InputReader();
        long sum = 0;
        int min = 10001;
        int max = 0;
        int num = 0;

        while(true) {
            try {
                num = reader.readInt();
            } catch (InputMismatchException e) {
                break;
            }

            linkedList.insert(num);

            sum += num;

            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }
        }

        System.out.println(min + " " + max + " " + sum);
    }

    private static class InputReader {
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

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}
