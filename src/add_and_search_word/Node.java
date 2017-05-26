package add_and_search_word;

/**
 * @author yejinbiao
 * @create 2017-05-26-13:22
 */

public class Node {
    Node[] childs;
    boolean isWord;
    boolean hasAnyChild;

    public Node() {
        this.childs = new Node[26];
    }
}