package implement_trie;

/**
 * @author yejinbiao
 * @create 2017-05-25-12:50
 */

public class Trie {
    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node node = root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a';
            if (node.childs[index] == null) {
                node.childs[index] = new Node();
            }
            if (i == chars.length - 1) {
                node.childs[index].isWord = true;
            }
            node = node.childs[c - 'a'];
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char [] chs = word.toCharArray();
        Node node = root;
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            int index = c - 'a';
            if (node.childs[index] == null) return false;
            if (i == chs.length - 1) {
                return node.childs[index].isWord;
            }
            node = node.childs[index];
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char [] chs = prefix.toCharArray();
        Node node = root;
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            int index = c - 'a';
            if (node.childs[index] == null) return false;
            node = node.childs[index];
        }
        return true;
    }

    private class Node {
        Node[] childs;
        boolean isWord;

        public Node() {
            this.childs = new Node[26];
        }
    }
}
