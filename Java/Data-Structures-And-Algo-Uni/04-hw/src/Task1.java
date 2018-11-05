import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Task1 {
    static class LinkedList {
        Node root;

        void insert(int value) {
            if (this.root == null) {
                this.root = new Node(value);
            } else {
                this.root.add(value);
            }
        }

        void print() {
            if (this.root == null) {
                System.out.println("Empty");
            } else {
                this.root.print();
            }
        }
    }

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }

        void add(int value) {
            if (this.next == null) {
                this.next = new Node(value);
            } else {
                this.next.add(value);
            }
        }

        void print() {
            System.out.println(this.value);

            if (this.next != null) {
                this.next.print();
            }
        }
    }

    public static void main(String[] args) {
        MyBufferedReader reader = new MyBufferedReader(System.in);
        LinkedList linkedList = new LinkedList();

        while(true) {
            try {
                String input = reader.readLine();
                if (input.equals("")) {
                    break;
                }
                linkedList.insert(Integer.parseInt(input));
            } catch (IOException e) {
                break;
            } catch (NumberFormatException e) {
                break;
            }
        }

        linkedList.print();
    }

    static class MyBufferedReader {
        private InputStream in;
        public MyBufferedReader (InputStream in) {this.in = in;}
        public String readLine() throws IOException {
            final StringBuffer sb = new StringBuffer(80);
            int i  = 0;
            while (((i = in.read()) != '\n') && (i != -1))
                if (i != '\r')
                    sb.append((char) i);
            if (i == -1)
                return null;
            return sb.toString();}
    }


    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

//    static class InputReader {
//        private InputStream stream;
//        private byte[] buf = new byte[1024];
//        private int curChar;
//        private int numChars;
//
//        InputReader() {
//            this.stream = System.in;
//        }
//
//        int read() {
//            if (numChars == -1)
//                throw new InputMismatchException();
//            if (curChar >= numChars) {
//                curChar = 0;
//                try {
//                    numChars = stream.read(buf);
//                } catch (IOException e) {
//                    throw new InputMismatchException();
//                }
//                if (numChars <= 0)
//                    return -1;
//            }
//            return buf[curChar++];
//        }
//
//        int readInt() {
//            int c = read();
//            while (isSpaceChar(c)) {
//                c = read();
//            }
//            int sgn = 1;
//            if (c == '-') {
//                sgn = -1;
//                c = read();
//            }
//            int res = 0;
//            do {
//                if (c < '0' || c > '9') {
//                    throw new InputMismatchException();
//                }
//                res *= 10;
//                res += c - '0';
//                c = read();
//            } while (!isSpaceChar(c));
//            return res * sgn;
//        }
//
//        long readLong() {
//            int c = read();
//            while (isSpaceChar(c)) {
//                c = read();
//            }
//            int sgn = 1;
//            if (c == '-') {
//                sgn = -1;
//                c = read();
//            }
//            long res = 0;
//            do {
//                if (c < '0' || c > '9') {
//                    throw new InputMismatchException();
//                }
//                res *= 10;
//                res += c - '0';
//                c = read();
//            } while (!isSpaceChar(c));
//            return res * sgn;
//        }
//
//        double readDouble() {
//            int c = read();
//            while (isSpaceChar(c)) {
//                c = read();
//            }
//            int sgn = 1;
//            if (c == '-') {
//                sgn = -1;
//                c = read();
//            }
//            double res = 0;
//            while (!isSpaceChar(c) && c != '.' && c != ',') {
//                if (c == 'e' || c == 'E') {
//                    return res * Math.pow(10, readInt());
//                }
//                if (c < '0' || c > '9') {
//                    throw new InputMismatchException();
//                }
//                res *= 10;
//                res += c - '0';
//                c = read();
//            }
//            if (c == '.' || c == ',') {
//                c = read();
//                double m = 1;
//                while (!isSpaceChar(c)) {
//                    if (c == 'e' || c == 'E') {
//                        return res * Math.pow(10, readInt());
//                    }
//                    if (c < '0' || c > '9') {
//                        throw new InputMismatchException();
//                    }
//                    m /= 10;
//                    res += (c - '0') * m;
//                    c = read();
//                }
//            }
//            return res * sgn;
//        }
//
//        String readLine() {
//            int c = read();
//            while (isSpaceChar(c))
//                c = read();
//            StringBuilder res = new StringBuilder();
//            do {
//                res.appendCodePoint(c);
//                c = read();
//            } while (!isSpaceChar(c));
//            return res.toString();
//        }
//
//        boolean isSpaceChar(int c) {
//            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
//        }
//    }
}
