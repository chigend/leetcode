package implement_trie;

/**
 * @author yejinbiao
 * @create 2017-05-25-13:07
 */

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        boolean search = trie.startsWith("hello");
        System.out.println(search);
    }
}
