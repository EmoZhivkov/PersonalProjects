package org.zoom;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pair<String, String> first = new Pair<>("Sofia", "Lom");
        Pair<String, String> second = new Pair<>("Lom", "Ruse");
        Pair<String, String> third = new Pair<>("Plovdiv", "Sofia");

        List<Pair<String, String>> tickets = new ArrayList<>();
        tickets.add(first);
        tickets.add(second);
        tickets.add(third);

        List<String> answer = FindRoute.execute(tickets);

        for (String string :
                answer) {
            System.out.println(string);
        }
    }
}
