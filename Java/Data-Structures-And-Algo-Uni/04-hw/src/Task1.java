import java.io.IOException;
import java.io.InputStream;

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

        Node next() {
            return this.next;
        }
    }

    public static void main(String[] args) {
        MyBufferedReader reader = new MyBufferedReader(System.in);
        LinkedList linkedList = new LinkedList();

        String input = new String();
        try {
            input = reader.readLine();
        } catch (IOException e) {

        }

        while(input != null) {
            try {
                linkedList.insert(Integer.parseInt(input));
                input = reader.readLine();
            } catch (IOException e) {
                break;
            } catch (NumberFormatException e) {
                break;
            }
        }

        int min = linkedList.root.value;
        int max = linkedList.root.value;
        long sum = 0;

        Node temp1 = linkedList.root;

        while (temp1.next != null) {
            if (temp1.value < min) {
                min = temp1.value;
            }
            if (temp1.value > max) {
                max = temp1.value;
            }
            sum += temp1.value;
            temp1 = temp1.next();
        }

        if (temp1.value < min) {
            min = temp1.value;
        }
        if (temp1.value > max) {
            max = temp1.value;
        }
        sum += temp1.value;


        System.out.println(min + " " + max + " " + sum);
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
}
