package backspace_string_compare;

/**
 * maybe a O(n) space solution, because variable in getDeletedString(String original) expand when string length grows
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean equal = solution.backspaceCompare("####","acs###");
        System.out.println(equal);
    }

    public boolean backspaceCompare(String S, String T) {
        String s = getDeletedString(S);
        String t = getDeletedString(T);
        return s.equals(t);
    }

    private String getDeletedString(String original) {
        char[] chs = original.toCharArray();
        StringBuilder sb = new StringBuilder();
        int backspace = 0;
        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] == '#') {
                backspace++;
            }else if (backspace > 0){
                backspace--;
            }else {
                sb.append(chs[i]);
            }
        }
        return sb.toString();
    }
}
