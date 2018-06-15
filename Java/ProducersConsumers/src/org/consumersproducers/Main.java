package org.consumersproducers;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Object object1 = new Object();
        Object object2 = new Object();

        BlockingQueue blockingQueue = new BlockingQueue(5, object1, object2);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i <= 10; i++) {
                    try {
                        System.out.println("Consumed: " + blockingQueue.pop());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i <= 10; i++) {
                    try {
                        blockingQueue.push(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Produced: " + i);
                }
            }
        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }
}
