package org.consumersproducers;

public class BlockingQueue {
    int currentElement;
    int[] arr;

    Object lockForProducers;
    Object lockForConsumers;

    BlockingQueue(int n, Object lockForProducers, Object lockForConsumers) {

        arr = new int[n];
        currentElement = n;
        this.lockForConsumers = lockForConsumers;
        this.lockForProducers = lockForProducers;
    }

    public void push(int num) throws InterruptedException{
        synchronized (lockForProducers) {
        while (isFull()) {
                lockForProducers.wait();
            }
            currentElement--;
            arr[currentElement] = num;
        }
        synchronized (lockForConsumers) {
            lockForConsumers.notify();
        }
    }

    public int pop() throws InterruptedException{
        synchronized (lockForConsumers) {
            while (isEmpty()) {
                lockForConsumers.wait();
            }
        }
        synchronized (lockForProducers) {
            lockForProducers.notify();
        }
        currentElement++;
        return arr[currentElement - 1];
    }

    public boolean isFull() {
        boolean b = false;
        if (this.currentElement == 0) {
            b = true;
        }
        return b;
    }

    public boolean isEmpty() {
        boolean b = false;
        if (this.currentElement == this.arr.length) {
            b = true;
        }
        return b;
    }
}
