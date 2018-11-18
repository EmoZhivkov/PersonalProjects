import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        //Scanner scanner = new Scanner(System.in);
        InputReader reader = new InputReader();

        long num = reader.readLong();

        if (num == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i <= num; i++) {
            if (i % 2 != 0) {
                linkedList.push(i);
            }
        }

        while (linkedList.size != 1) {
            linkedList.push(linkedList.pop());
            linkedList.pop();
        }

        System.out.println(linkedList.pop());
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

    static class LinkedList {
        Node last;
        Node first;
        int size;

        LinkedList() {
            this.first = this.last = null;
            this.size = 0;
        }

        void push(long value) {
            Node temp = new Node(value);

            if (this.last == null) {
                this.first = this.last = temp;
                return;
            }

            this.last.next = temp;
            this.last = temp;
            this.size++;
        }

        long pop() {
            if (this.first == null) {
                return -1;
            }

            Node temp = this.first;
            this.first = this.first.next;

            if (this.first == null){
                this.last = null;
            }

            this.size--;

            return temp.value;
        }

        void print() {
            Node temp = this.first;
            System.out.println(temp.value);

            while (temp.hasNext()) {
                temp = temp.getNext();
                System.out.println(temp.value);
            }
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    static class Node{
        long value;
        Node next;

        Node(long value) {
            this.value = value;
            this.next = null;
        }

        Node getNext() {
            return this.next;
        }

        boolean hasNext() {
            return this.next != null;
        }
    }
}
