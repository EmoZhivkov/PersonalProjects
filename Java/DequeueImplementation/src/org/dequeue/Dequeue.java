package org.dequeue;

import java.util.LinkedList;

public class Dequeue {
    LinkedList<String> queue;

    Dequeue() {
        queue = new LinkedList<>();
    }

    public void enqueueFront(String input) {
        queue.addLast(input);
    }

    public void enqueueBack(String input) {
        queue.addFirst(input);
    }

    public String dequeueFront() {
        return queue.removeFirst();
    }

    public String dequeueBack() {
        return queue.removeLast();
    }
}
