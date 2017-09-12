package implement_magic_dictionary;

public class MagicDictionary {
    private Node root;

    public MagicDictionary() {
        root = new Node();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            insert(word);
        }
    }

    private void insert(String word) {
        Node node = root;
        char[] chs = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int index = chs[i] - 'a';
            Node child = node.childs[index];
            if (child == null) {
                child = new Node();
                node.childs[index] = child;
            }
            node = child;
        }
        //mark the last node the word can reach as isWord
        node.isWord = true;
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        return search(root, word.toCharArray(), 0, 1);
    }

    public boolean search(Node node, char[] words, int cursor, int modify) {
        if (cursor >= words.length) {
            return modify == 0 && node.isWord;
        }
        int index = words[cursor] - 'a';
        Node child = node.childs[index];
        if (modify == 1) {//if there are one chance left to modify the character,
            //just search the other node skip the current (it means modify the current character)
            for (int i = 0; i < node.childs.length; i++) {
                if (node.childs[i] != null && node.childs[i] != child) {
                    boolean exist = search(node.childs[i], words, cursor + 1,  0);
                    //one path exist return true;
                    if (exist) {
                        return true;
                    }
                }
            }
        }
        //if modify chance has used up, just search deeper in case the child is not null
        return child != null && search(child, words, cursor + 1, modify);
    }

    private class Node {
        private Node[] childs;
        private boolean isWord;

        public Node() {
            childs = new Node[26];
        }
    }
}
