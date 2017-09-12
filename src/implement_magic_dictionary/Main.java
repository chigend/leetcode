package implement_magic_dictionary;

public class Main {
    public static void main(String[] args) {
        MagicDictionary dictionary = new MagicDictionary();
        dictionary.buildDict(new String[] {"hello", "hallo","leetcode"});
        System.out.println(dictionary.search("hello"));
        System.out.println(dictionary.search("hallo"));
        System.out.println(dictionary.search("hhllo"));
        System.out.println(dictionary.search("leetcode"));
        System.out.println(dictionary.search("leetcodd"));
        System.out.println(dictionary.search("aaaaa"));
        System.out.println(dictionary.search("hhldo"));
    }
}
