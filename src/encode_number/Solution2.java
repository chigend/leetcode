package encode_number;

public class Solution2 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ":" + encode(i));
            ;
        }
    }

        public static String encode(int num) {
            return Integer.toBinaryString(num + 1).substring(1);

        }
}
