package org.dequeue;

public class Main {
    public static void main(String[] args) {
        Dequeue test = new Dequeue();
        test.enqueueFront("hello");
        test.enqueueFront("world");

        System.out.println(test.dequeueBack());
        System.out.println(test.dequeueBack());
    }
}
