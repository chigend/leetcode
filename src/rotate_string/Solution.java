package rotate_string;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean can = solution.rotateString("abcde", "eabcf");
        System.out.println(can);
    }

    public boolean rotateString(String A, String B) {
        if (A.equals(B)) {
            return true;
        }
        for(int shift = 0; shift < A.length(); shift++) {
            if(A.charAt(shift) == B.charAt(0)) {
                if ((A.substring(shift) + A.substring(0, shift)).equals(B)) {
                    return true;
                }
            }
        }
        return false;
    }

}
