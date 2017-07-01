package word_break;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-07-01-10:05
 */

public class Solution {
    public static void main(String[] args) {
        String target = "helloworld";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("hello");
        dictionary.add("world");
        boolean canBreak = wordBreak(target,dictionary);
        System.out.println(canBreak);

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        /**
         *  dp[i] means if the string before i(not the index,it start from 1) th character in s
         *  can break into words.
         */
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                int len = word.length();
                /**
                 * every time we meet a word in dictionary, we judge if
                 * the string before (i-len) can break,if it can not be
                 * break,there is no need to go along,otherwise,then,
                 * we judge if the string between(i-len) and i equals
                 * the current word in dictionary
                 *
                 * for example, given s="leetcode" and dictionary ["leet","code"]
                 * we iterate i from 1 to s.length,here from 1 to 8
                 * since character before t, the length is no more than
                 * any word in dictionary,so we just ignore,and the dp[1]-dp[3] will
                 * be set to false.when i arrive 4,here it means arrive to the
                 * character 't',we judge dp[i  - len] = dp[4-4] = dp[0](this is why we
                 * initially set dp[0] = true),since dp[0] = true,we come to substring string
                 * between (i -len) and i , here s.substring(0,4) = "leet",it equals
                 * the first string in dictionary.so we find it and break the inner loop,
                 * so we set dp[i] = dp[4] = true, it means string before the 4th
                 * character (inclusive)in s can break into words.
                 */
                if (len <= i && dp[i-len]) {
                    if (s.substring(i - len,i).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
