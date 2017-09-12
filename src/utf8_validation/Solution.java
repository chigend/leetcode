package utf8_validation;

public class Solution {
    public static void main(String[] args) {
//                int n = countN(128);
//        System.out.println(138 & 192 ^ 64);
        boolean valid = validUtf8(new int[]{248,130,130,130});
        System.out.println(valid);
    }

    public static boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int num = data[i];
            if (num > 255) {
                return false;
            }
            // 1-byte character
            if ((num & 128) == 0) {
                continue;
            }
            int n = countN(num);
            // n [2,3,4]
            if (n > 1) {
                while (--n > 0) {
                    i++;
                    //if there are not enough num follow, it is not valid
                    if (i >= data.length) {
                        return false;
                    }
                    //judge if the number follow start with 10 in binary string

                    if ((data[i] & 192) != 128) {
                        return false;
                    }
                }
            }else {
                //there is only one leading 1
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param num
     * @return return the number of bytes the num represent, since utf-8 has at most 4 bytes, so we cut it
     * when it is larger than 4
     */
    private static int countN(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 128) == 128) {
                count++;
            }else {
                break;
            }
            num <<= 1;
        }
        return count <= 4 ? count : 0;
    }
}
