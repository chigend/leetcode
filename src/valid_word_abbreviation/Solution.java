package valid_word_abbreviation;

public class Solution {

    public static void main(String[] args) {
        String[] words = new String[]{"word","1ord","w1rd","wo1d","wor1","2rd","w2d","wo2","1o1d","1or1","w1r1","1o2","2r1","3d","w3","4"};
//        for (String abbr : words) {
//            if (!valid("word", abbr)) {
//                System.out.print("wrong");
//            }
//        }

        System.out.println(validWordAbbreviation("a", "01"));
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        char[] chs = word.toCharArray();
        char[] abbrChs = abbr.toCharArray();
        int wordIndex = 0;
        int abbrIndex = 0;
        int countChar = 0;
        while (wordIndex < chs.length && abbrIndex < abbrChs.length) {
            if (Character.isDigit(abbrChs[abbrIndex])) {
                countChar = countChar * 10 + (abbrChs[abbrIndex] - '0');
                if (countChar == 0) {
                    return false;
                }
                abbrIndex++;
                continue;
            }
            wordIndex += countChar;
            countChar = 0;
            if (wordIndex < chs.length
                    && chs[wordIndex++] != abbrChs[abbrIndex++]) {
                return false;
            }
        }
        return wordIndex + countChar == chs.length && abbrIndex == abbrChs.length;
    }
}
