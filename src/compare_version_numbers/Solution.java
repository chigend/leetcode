package compare_version_numbers;

/**
 * 2016/11/23
 */
public class Solution {
    public static void main(String[] args) {
        int c = compareVersion("1","1.1");

        System.out.print(c);
    }
    public static  int compareVersion(String version1, String version2) {
        String [] versions1 = version1.split("\\.");
        String [] versions2 = version2.split("\\.");
        int length = Math.max(versions1.length,versions2.length);
        for (int i=0; i< length;i++){
            Integer c1 = i >= versions1.length ? 0:Integer.parseInt(versions1[i]);
            Integer c2 = i >= versions2.length ? 0:Integer.parseInt(versions2[i]);
            int compare = c1.compareTo(c2);
            if(c1 != c2){
                return compare;
            }
        }
        return 0;
    }

}
