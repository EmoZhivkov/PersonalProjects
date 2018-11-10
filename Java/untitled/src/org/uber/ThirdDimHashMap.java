package org.uber;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ThirdDimHashMap<K, V> {
    Map<K, BST> map;

    public ThirdDimHashMap() {
        map = new HashMap<>();
    }

    public V get(K key, int time) {
        if (map.containsKey(key)) {
            BST tree = map.get(key);
            return tree.get(time);
        } else {
            return null;
        }
    }

    public void set(K key, V value, int time) {
        Pair<Integer, V> temp = new Pair<>(time, value);
        if (this.map.containsKey(key)) {
            BST tree = map.get(key);
            tree.put(temp);
        } else {
            BST tree = new BST();
            tree.put(temp);
            map.put(key, tree);
        }
    }
}
