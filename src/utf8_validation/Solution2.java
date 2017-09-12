package utf8_validation;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(validUtf8(new int[] {150,191,191}));
    }

    public static boolean validUtf8(int[] data) {
        String[] binarys = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 255) {
                return false;
            }
            binarys[i] = toBinaryString(data[i]);
        }
        for (int i = 0; i < binarys.length; i++) {
            int n = nthCharacter(binarys[i]);
            if (n == -1) {
                return false;
            }
            if (n > 1) {
                if (!isValidNthCharacter(binarys, i + 1, i + n - 1)) {
                    return false;
                }
                i += n - 1;
            }
        }
        return true;
    }

    private static boolean isValidNthCharacter(String[] binarys, int start, int end) {
        if (end > binarys.length - 1) {
            return false;
        }
        for (int i = start; i <= end; i++) {
            if (!binarys[i].startsWith("10")) {
                return false;
            }
        }
        return true;
    }

    private static String toBinaryString(int num) {
        String numStr = Integer.toBinaryString(num);
        while (numStr.length() < 8) {
            numStr = "0" + numStr;
        }
        return numStr;
    }

    private static int nthCharacter(String binary) {
        int count = 0;
        char[] chs = binary.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '1') {
                count++;
            }else {
                break;
            }
        }
        if (count == 1) {
            return -1;
        }
        if (count == 0) {
            return 1;
        }
        return count <= 4 ? count : -1;
    }
}
