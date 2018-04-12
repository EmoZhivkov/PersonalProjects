package org.hash;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Person gosho = new Person("Gosho", 36654);
        Person pencho = new Person("Pencho", 6874);
        Person iliicho = new Person("Iliicho", 87684);
        Person marto = new Person("marto", 6846685);

        HashMap grades = new HashMap();

        grades.insert(gosho, 4);
        grades.insert(pencho, 3);
        grades.insert(iliicho, 5);
        grades.insert(marto, 6);

        HashEntry e = grades.get(iliicho);
        System.out.println( e.getGrade());

    }
}
