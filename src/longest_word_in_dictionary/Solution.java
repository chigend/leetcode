package longest_word_in_dictionary;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "applz"};
        String word = longestWord(words);
        System.out.println(word);
    }

    public static String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie.getLongestWord();
    }

    static class Trie{
        Node root;
        String word;
        int max;
        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            char[] chs = word.toCharArray();
            Node node = root;
            for (int i = 0; i < chs.length; i++) {
                int index = chs[i] - 'a';
                Node child = node.childs[index];
                if (child == null) {
                    child = new Node();
                    node.childs[index] = child;
                }
                if (i == chs.length - 1) {
                    node.hasWordChild = true;
                    child.isWord = true;
                }
                node = child;
            }

        }

        public String getLongestWord() {
            dfs(root, 0 , new StringBuilder());
            return word;
        }

        public void dfs(Node root, int len, StringBuilder sb) {
            if (!root.hasWordChild) {
                if (len > max) {
                    max = len;
                    word = sb.toString();
                }else if (len == max && sb.toString().compareTo(word) < 0) {
                    word = sb.toString();
                }
            }else {
                for (int i = 0; i < 26; i++) {
                    Node child = root.childs[i];
                    if (child != null && child.isWord) {
                        sb.append((char)('a' + i));
                        dfs(child, len + 1, sb);
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        }
    }

    static class Node{
        Node[] childs;
        boolean isWord;
        boolean hasWordChild;

        public Node() {
            this.childs = new Node[26];
        }
    }
}
