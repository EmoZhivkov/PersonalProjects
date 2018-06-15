package org.countfiles;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static volatile AtomicInteger numberOfFiles = new AtomicInteger(0);
    static volatile AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException{
        long start = System.currentTimeMillis();
        filesCountInAGivenDirectory("C:\\Program Files");
        System.out.println(numberOfFiles);

        System.out.println(System.currentTimeMillis() - start);
    }

    public static void filesCountInAGivenDirectory(String path) {
        File[] directories;
        try {
            directories = new File(path).listFiles(File::isDirectory);

            numberOfFiles.addAndGet(new File(path).listFiles().length);
            numberOfFiles.addAndGet(-directories.length);

            for (int i = 0; i < directories.length; i++) {

                String currentPath = directories[i].getPath();
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
