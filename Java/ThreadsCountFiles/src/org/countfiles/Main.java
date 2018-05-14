package org.countfiles;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static Object lock = new Object();

    static volatile AtomicInteger numberOfFiles = new AtomicInteger(0);
    static volatile AtomicInteger helper = new AtomicInteger(3);

    static volatile AtomicInteger counter = new AtomicInteger(0);
    static volatile String currentPath = "";
    //static ArrayList<File[]> groupOfDirectiories = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException{
        long start = System.currentTimeMillis();
        filesCountInAGivenDirectory("D:\\Apps");
        System.out.println(numberOfFiles);

        System.out.println(System.currentTimeMillis() - start);
    }

    public static void filesCountInAGivenDirectory(String path) {
        /*if (!Thread.currentThread().getName().equals("main")) {*/
            System.out.println(Thread.currentThread().getName());
        //}

        File[] directories;
        try {
            directories = new File(path).listFiles(File::isDirectory);

                /*numberOfFiles = numberOfFiles + new File(path).listFiles().length;
                numberOfFiles = numberOfFiles - directories.length;*/

            numberOfFiles.addAndGet(new File(path).listFiles().length);
            numberOfFiles.addAndGet(-directories.length);

            for (int i = 0; i < directories.length; i++) {

                currentPath = directories[i].getPath();
                if (counter.compareAndSet(4, 4)) {
                    counter.getAndSet(0);
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            filesCountInAGivenDirectory(currentPath);
                            counter.incrementAndGet();
                        }
                    });
                    thread.start();

                } else {
                    filesCountInAGivenDirectory(currentPath);
                    counter.incrementAndGet();
                }
            }
        } catch (NullPointerException e) {

        }
    }
}
