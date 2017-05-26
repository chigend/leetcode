package add_and_search_word;

/**
 * @author yejinbiao
 * @create 2017-05-26-13:20
 */

public class WordDictionary2 {
    Node root;
    int maxDepth;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary2() {
        root = new Node();
        maxDepth = 0;
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        Node node = root;
        maxDepth = Math.max(maxDepth, word.length());
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
        if (word.length() > maxDepth)
            return false;
        return search(root, word);
    }

    private boolean search(Node node, String word) {
        char[] chs = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char c = chs[i];
            int index = c - 'a';
            if (c != '.') {
                if (node.childs[index] == null)
                    return false;
                if (i == word.length() - 1) {
                    return node.childs[index].isWord;
                }
                node = node.childs[index];
            } else {
                if (!node.hasAnyChild)
                    return false;
                if (i == word.length() - 1) {
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
                        if (search(child, new String(chs, i + 1, word.length() - 1 - i)))
                            return true;
                    }
                }
                return false;

            }

        }
        return true;
    }

}