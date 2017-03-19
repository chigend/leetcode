package integer_to_english_words;

/**
 * @author yejinbiao
 * @create 2017-03-19-下午7:20
 */

public class Solution {
    public static void main(String[] args) {
        String englishWords = numberToWords(1200);
        System.out.print(englishWords);
    }

    public static String numberToWords(int num) {
        String [] levels = {"", " Thousand"," Million"," Billion"};
        String [] numbers = {""," One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"," Ten",
                    " Eleven"," Twelve"," Thirteen"," Fourteen"," Fifteen"," Sixteen"," Seventeen"," Eighteen"," Nineteen"};
        String [] tens = {"",""," Twenty"," Thirty"," Forty"," Fifty"," Sixty"," Seventy"," Eighty"," Ninety"};
        int level = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int num_3 = num % 1000;
            if (num_3 != 0) {
                sb.insert(0,levels[level]);
            }
            int num_2 = num_3 % 100;
            if (num_2 < 20) {
                sb.insert(0,numbers[num_2]);
            }else {
                int ten = num_2 / 10;
                int digit = num_2 % 10;
                sb.insert(0, numbers[digit]);
                sb.insert(0, tens[ten]);
            }
            int hundred = num_3 / 100;
            if (hundred > 0) {
                sb.insert(0," Hundred");
                sb.insert(0,numbers[hundred]);
            }
            level++;
            num /= 1000;
        }
        return sb.toString().substring(1);
    }
}
