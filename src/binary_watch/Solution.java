package binary_watch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-06-22-10:11
 */

public class Solution {
    private static int[] hour = new int[] {1,2,4,8};
    private static int[] minute = new int[] {1,2,4,8,16,32};
    private static String temp = "";
    private static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        List<String> list = readBinaryWatch(2);
        System.out.println(list.size());
    }

    public static List<String> readBinaryWatch(int num) {
        for (int i = 0; i <= num; i++) {
            backtraceHour(i,num-i,0,0);
        }
        return list;
    }

    /**
     *
     * @param n 小时区亮灯的个数
     * @param m 分钟区亮灯的个数
     * @param start
     * @param result 小时区累计的时间
     */
    private static void backtraceHour(int n,int m,int start,int result){
        if (n == 0) {
            if (result >= 12) return;//小时范围为0-11，超过11的部分直接丢弃
            temp += result;
            backtraceMinute(m,0,0);
            temp = "";
            return;
        }
        for (int i = start ; i < hour.length;i++) {
            backtraceHour(n-1,m,i+1,result | hour[i]);
        }
    }

    /**
     *
     * @param m  分钟区亮灯的个数
     * @param start
     * @param result 分钟区累计的时间
     */
    private static void backtraceMinute(int m,int start,int result) {
        if (m == 0) {
            if (result >= 60) return;//分钟范围为0-59，超过59的部分直接丢弃
            if (result < 10) list.add(new String(temp+":0"+result));
            else list.add(new String(temp + ":"+ result));
            return;
        }
        for (int i = start ; i < minute.length;i++) {
            backtraceMinute(m-1,i+1,result | minute[i]);
        }
    }
}
