package add_and_search_word;

/**
 * @author yejinbiao
 * @create 2017-05-26-13:20
 */

public class Main {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        wordDictionary.addWord("bat");
        boolean a = wordDictionary.search("b.");
        System.out.println(a);
    }
}
