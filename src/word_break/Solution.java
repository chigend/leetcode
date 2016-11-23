package word_break;

import java.util.HashSet;
import java.util.Set;

/**
 * 2016/11/22
 */
public class Solution {
    public static void main(String[] args) {
        Set<String> dic = new HashSet<>();
        dic.add("aaaa");
        dic.add("aaa");
        String s = "aaaaaaa";
        boolean canBreak = wordBreak(s,dic);
        System.out.print(canBreak);
    }
    public static boolean wordBreak(String s, Set<String> wordDict) {
        
        //// TODO: 2016/11/23
        //定义比字符串长度多一的数组
//        boolean [] dp = new boolean [s.length()+1];
//        //dp[i]表示字符串前i个字符是可拆的，dp[0]表示前0个字符可拆
//        dp[0] = true;
//        for (int i=0;i<s.length();i++){
//            if(dp[i]){
//                int index = i;
//                for (int j=i;j<s.length();j++){
//                    String tmp = s.substring(index,j-i+1);
//                    if(wordDict.contains(tmp)){
//                        dp[j+1] = true;
//                        i = j;
//                        break;
//                    }
//                }
//            }
//        }
//        return dp[s.length()];
        return true;
    }
}
