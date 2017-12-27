package ip_to_cidr;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public static List<String> ipToCIDR(String ip, int n) {
        List<String> res = new ArrayList<>();
        String[] ipStrs = ip.split("\\.");
        int ipNum = 0;
        for (String ipStr : ipStrs) {
            ipNum <<= 8;
            ipNum |= Integer.parseInt(ipStr);
        }
        while (n != 0) {
            int num = ipNum;
            /**
             * num & -num to get lowest bit
             */
            int step = num & -num;
            while (step > n) {
                step /= 2;
            }
            res.add(constructCIDR(ipNum, step));
            int covered = step;
            n -= covered;
            ipNum += covered;
        }
        return res;
    }

    public static String constructCIDR(int ip, int step) {
        StringBuilder sb = new StringBuilder();
        int[] ipSegments = new int[4];
        int index = ipSegments.length - 1;
        while (ip != 0) {
            ipSegments[index--] = ip & 255;
            ip >>>= 8;
        }
        sb.append(ipSegments[0]).append('.');
        sb.append(ipSegments[1]).append('.');
        sb.append(ipSegments[2]).append('.');
        sb.append(ipSegments[3]);
        int prefix = 33;
        while (step != 0) {
            step /= 2;
            prefix--;
        }
        return sb.append("/").append(prefix).toString();
    }
}
