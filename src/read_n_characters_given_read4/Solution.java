package read_n_characters_given_read4;

public class Solution extends Reader4 {

    public static void main(String[] args) {

    }

    public int read(char[] buf, int n) {
        int total = 0;
        char[] chs = new char[4];
        int bytes;
        while ((bytes = read4(chs)) != 0) {
            int read = Math.min(n - total, bytes);
            System.arraycopy(chs, 0, buf, total, read);
            total += read;
        }
        return total;
    }
}
