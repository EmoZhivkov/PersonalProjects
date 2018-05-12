package org.countfiles;

import java.io.File;
import java.util.ArrayList;

public class Main {
    static int numberOfFiles = 0;

    static int counter = 0;
    static ArrayList<File[]> groupOfDirectiories = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException{
        long start = System.currentTimeMillis();

        System.out.println(filesCountInAGivenDirectory("D:\\Apps"));

        System.out.println(System.currentTimeMillis() - start);
    }

    public static int filesCountInAGivenDirectory(String path) {
            try {
                numberOfFiles = numberOfFiles + new File(path).listFiles().length;

                File[] directories = new File(path).listFiles(File::isDirectory);

                for (int i = 0; i < directories.length; i++) {

                    groupOfDirectiories.add(counter, new File(directories[i].getPath()).listFiles());
                    if (counter == 4) {
                        counter = 0;
                        for (int j = 0; j < 4; j++) {
                        }
                    }

                    filesCountInAGivenDirectory(directories[i].getPath());

                    counter++;
                    numberOfFiles--;
                }
            } catch (NullPointerException e) {
                numberOfFiles = numberOfFiles + 0;
            }
        return numberOfFiles;
    }
}
