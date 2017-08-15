package replace_words;

import java.util.Arrays;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-08-15-9:40
 */

public class Solution {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = replaceWords(dict, "cattle");
        System.out.print(sentence);
    }

    public static String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }
        String[] words = sentence.split("\\s");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String prefix = trie.shortestPrefix(word);
            words[i] = prefix;
        }
        return String.join(" ", words);
    }

    static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            char[] chs = word.toCharArray();
            Node node = root;
            for (int i = 0; i < chs.length; i++) {
                int index = chs[i] - 'a';
                if (node.childs[index] == null) {
                    node.childs[index] = new Node();
                }
                Node child = node.childs[index];
                node = child;
            }
            node.isWord = true;
        }

        public String shortestPrefix(String word) {
            char[] chs = word.toCharArray();
            Node node = root;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chs.length; i++) {
                int index = chs[i] - 'a';
                if (node.childs[index] == null) {
                    return word;
                }
                Node child = node.childs[index];
                sb.append(chs[i]);
                if (child.isWord) {
                    return sb.toString();
                }
                node = child;
            }
            return word;
        }
    }

    static class Node {
        Node[] childs;
        boolean isWord;

        public Node() {
            childs = new Node[26];
        }
    }
}
