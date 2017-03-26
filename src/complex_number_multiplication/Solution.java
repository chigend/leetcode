package complex_number_multiplication;

/**
 * @author yejinbiao
 * @create 2017-03-26-10:03
 */

public class Solution {
    public static void main(String[] args) {
        String a = "1+-1i";
        String b = "1+-1i";
        String res = complexNumberMultiply(a,b);
        System.out.println(res);
    }
    public static String complexNumberMultiply(String a, String b) {
    String [] num1 = a.split("\\+");
    int numa = Integer.parseInt(num1[0]);
    int numb = Integer.parseInt(num1[1].substring(0, num1[1].length() - 1));
    String [] num2 = b.split("\\+");
    int numc = Integer.parseInt(num2[0]);
    int numd = Integer.parseInt(num2[1].substring(0, num2[1].length() - 1));
    int shi = numa * numc - numb * numd;
    int xu = numa * numd + numb * numc;
    StringBuilder sb = new StringBuilder();
    sb.append(shi).append("+").append(xu).append("i");
    return sb.toString();
}
}
