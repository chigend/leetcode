package add_and_search_word;

/**
 * @author yejinbiao
 * @create 2017-05-26-13:22
 */

public class WordDictionary {
    Node root;
    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        Node node = root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a';
            if (node.childs[index] == null) {
                node.childs[index] = new Node();
                node.hasAnyChild = true;
            }
            node = node.childs[index];
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {

        return search(root, word.toCharArray(), 0);
    }

    private boolean search(Node node, char[] words, int cusor) {
        if (cusor >= words.length)
            return node.isWord;
        char c = words[cusor];
        int index = c - 'a';
        if (c != '.') {
            if (node.childs[index] == null)
                return false;
            return search(node.childs[index], words, cusor + 1);
        } else {
            if (!node.hasAnyChild)
                return false;
            if (cusor == words.length - 1) {
                for (int j = 0; j < node.childs.length; j++) {
                    Node child = node.childs[j];
                    if (child != null && child.isWord) {
                        return true;
                    }
                }
                return false;
            }
            for (int j = 0; j < node.childs.length; j++) {
                Node child = node.childs[j];
                if (child != null) {
                    if (search(child, words, cusor + 1))
                        return true;
                }
            }
            return false;
        }
    }

}
