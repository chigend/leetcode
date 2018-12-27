package rotate_string;

public class Solution2 {
    public static void main(String[] args) {

    }

    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && A.concat(A).contains(B);
    }
}
