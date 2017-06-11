package design_compressed_string_iterator;

/**
 * @author yejinbiao
 * @create 2017-06-11-17:09
 */
public class StringIterator {
    private char current;
    private int count;

    private int nextIndex ;
    private String compressedString;

    public StringIterator(String compressedString) {
        if (compressedString == null || compressedString.length() == 0) {
            nextIndex = -1;
        }
        this.compressedString = compressedString;
    }

    public char next() {
        //if the current char has left,just return the current char,and count down the remain number
        if (count != 0) {
            count--;
            return current;
        }
        //if the current char has been consumed out,and there is not another char ,return blank ' '
        if (nextIndex == -1)
            return ' ';
        //update the current char since there is another char(index will not be -1)
        current = compressedString.charAt(nextIndex);
        boolean reachEnd = true;
        //the start index where the positive number starts
        int start = nextIndex + 1;
        for (int i = start; i < compressedString.length(); i++) {
            char c = compressedString.charAt(i);
            if (Character.isAlphabetic(c)) {
                //if find a another char,it means has not got the end of the string
                reachEnd = false;
                //and update the next char index
                nextIndex = i;
                break;
            }
        }
        if (!reachEnd) {
            count = Integer.parseInt(compressedString.substring(start, nextIndex));
        } else {
            //if reach the end of string,there is not another char exist,so set index to -1
            nextIndex = -1;

            count = Integer.parseInt(compressedString.substring(start, compressedString.length()));
        }
        count--;
        return current;
    }

    public boolean hasNext() {
        return count != 0 || nextIndex != -1;
    }
}