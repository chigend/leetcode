package design_compressed_string_iterator;

/**
 * @author yejinbiao
 * @create 2017-06-11-17:09
 */
public class StringIterator {
    private char current;
    private int count;
    private char nextChar;
    private int nextIndex = -1;
    private String compressedString;

    public StringIterator(String compressedString) {
        if (compressedString == null || compressedString.length() == 0){
            nextChar = ' ';
        }else {
            this.compressedString = compressedString;
            current = compressedString.charAt(0);
            boolean reachEnd = true;
            for (int i = 1; i < compressedString.length(); i++) {
                char c = compressedString.charAt(i);
                if (Character.isAlphabetic(c)){
                    reachEnd = false;
                    nextIndex = i;
                    nextChar = c;
                    break;
                }
            }
            if(!reachEnd){
                count = Integer.parseInt(compressedString.substring(1,nextIndex));
            }else {
                nextChar = ' ';
                count = Integer.parseInt(compressedString.substring(1,compressedString.length()));
            }

        }
    }

    public char next() {
       if (count != 0) {
           count --;
           return current;
       }
       if (nextChar == ' ') return nextChar;
       current = nextChar;
        boolean reachEnd = true;
        int start = nextIndex + 1;
        for (int i = nextIndex+1; i < compressedString.length(); i++) {
            char c = compressedString.charAt(i);
            if (Character.isAlphabetic(c)){
                reachEnd = false;
                nextIndex = i;
                nextChar = c;
                break;
            }
        }
        if(!reachEnd){
            count = Integer.parseInt(compressedString.substring(start,nextIndex));
        }else {
            nextChar = ' ';
            count = Integer.parseInt(compressedString.substring(start,compressedString.length()));
        }
        count--;
        return current;
    }

    public boolean hasNext() {
        return count != 0 || nextChar != ' ';
    }
}