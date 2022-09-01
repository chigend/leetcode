package increasing_decreasing_string;

class Solution {
    public String sortString(String s) {
        int[] alphabet = new int[26];
        char[] chs = s.toCharArray();
        int total = chs.length;
        for(int i = 0; i < chs.length; i++) {
            alphabet[chs[i] - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while(total > 0) {
            for(int i = 0; i < alphabet.length; i++) {
                if(alphabet[i]-- > 0) {
                    sb.append((char)('a' + i));
                    total--;
                }
            }

            for(int i = alphabet.length - 1; i >= 0; i--) {
                if(alphabet[i]-- > 0) {
                    sb.append((char)('a' + i));
                    total--;
                }
            }

        }
        return sb.toString();
    }
}