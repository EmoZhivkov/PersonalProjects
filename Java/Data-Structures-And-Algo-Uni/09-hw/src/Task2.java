import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    static class TrieNode {
        TrieNode[] arr;
        boolean isEnd;

        TrieNode() {
            this.arr = new TrieNode[26];
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (p.arr[index] == null) {
                    TrieNode temp = new TrieNode();
                    p.arr[index] = temp;
                    p = temp;
                } else {
                    p = p.arr[index];
                }
            }
            p.isEnd = true;
        }

        boolean search(String word) {
            TrieNode p = searchNode(word);
            if (p == null) {
                return false;
            } else {
                if (p.isEnd)
                    return true;
            }

            return false;
        }

        boolean startsWith(String prefix) {
            TrieNode p = searchNode(prefix);
            if (p == null) {
                return false;
            } else {
                return true;
            }
        }

        TrieNode searchNode(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = c - 'a';
                if (p.arr[index] != null) {
                    p = p.arr[index];
                } else {
                    return null;
                }
            }

            if (p == root)
                return null;

            return p;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        Map<String, Integer> map = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();

        String[] strings = new String[len];
        for (int i = 0; i < len; i++) {
            strings[i] = scanner.next();

            boolean flag = true;
            for (int j = 1; j <= strings[i].length(); j++) {
                String current = strings[i].substring(0, j);

                if (!trie.startsWith(current)) {
                    System.out.println(current);
                    flag = false;
                    break;
                }
            }

            if (!map.containsKey(strings[i])) {
                map.put(strings[i], 1);
                if (flag) {
                    System.out.println(strings[i]);
                }
            } else {
                map.put(strings[i], map.get(strings[i]) + 1);
                System.out.println(strings[i] + " " + map.get(strings[i]));
            }

            trie.insert(strings[i]);
        }
    }
}
