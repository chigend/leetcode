package student_attendance_record_I;

/**
 * @author yejinbiao
 * @create 2017-06-21-10:48
 */

public class Solution {
    public static void main(String[] args) {
        boolean reward = checkRecord("LLPLLPLLALLPLL");
        System.out.println(reward);
    }
    public static boolean checkRecord(String s) {
        int aCount = 0;
        int lCount = 0;
        boolean lContinuous = false;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            switch (c){
                case 'A':

                    if (++aCount > 1) return false;
                    lContinuous = false;
                    lCount = 0;
                    break;
                case 'L':
                    if (++lCount > 2 && lContinuous) {
                        return false;
                    }
                    lContinuous = true;
                    break;
                case 'P':
                    lContinuous = false;
                    lCount = 0;
            }
        }
        return true;
    }
}
