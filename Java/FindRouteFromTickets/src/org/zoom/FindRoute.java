package org.zoom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindRoute {
    private static List<String> getRouteFromPairs(List<Pair<String, String>> temp) {
        List<String> route = new ArrayList<>();
        route.add(temp.get(0).first);

        for (Pair<String, String> pair :
                temp) {
            route.add(pair.second);
        }

        return route;
    }

    public static List<String> execute(List<Pair<String, String>> temp) {
        List<Pair<String, String>> route = new LinkedList<>();
        while (!temp.isEmpty()) {

            List<Pair<String, String>> removeEl = new ArrayList<>();

            for (Pair<String, String> current :
                    temp) {

                if (route.isEmpty()) {
                    route.add(current);
                    removeEl.add(current);
                    continue;
                }

                String first = current.first;
                String second = current.second;

                if (second.equals(((LinkedList<Pair<String, String>>) route).getFirst().first)) {
                    ((LinkedList<Pair<String, String>>) route).addFirst(current);
                    removeEl.add(current);
                } else if (first.equals(((LinkedList<Pair<String, String>>) route).getLast().second)) {
                    ((LinkedList<Pair<String,String>>) route).addLast(current);
                    removeEl.add(current);
                }

            }

            temp.removeAll(removeEl);
        }
        return getRouteFromPairs(route);
    }
}
