package valid_number;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.isNumber("e"));
    }

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        return validateOrdinaryNumber(s) || validateDecimal(s) || validateScienceNumber(s);
    }

    private boolean validateOrdinaryNumber(String s) {
        char maybeSymbol = s.charAt(0);
        boolean isFirstCharacterSymbol = false;
        if (maybeSymbol == '+' || maybeSymbol == '-') {
            isFirstCharacterSymbol = true;
        }

        int start = 0;
        if (isFirstCharacterSymbol) {
            if (s.length() < 2) {
                return false;
            }
            start = 1;
        }
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean validateDecimal(String s) {
        char maybeSymbol = s.charAt(0);
        boolean isFirstCharacterSymbol = false;
        if (maybeSymbol == '+' || maybeSymbol == '-') {
            isFirstCharacterSymbol = true;
        }

        int start = 0;
        if (isFirstCharacterSymbol) {
            if (s.length() < 3) {
                return false;
            }
            start = 1;
        }
        boolean dotAppear = false;
        boolean numberAppear = false;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                if (dotAppear) {
                    return false;
                }
                dotAppear = true;
                continue;
            }
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }else {
                numberAppear = true;
            }
        }
        return numberAppear;
    }
    private boolean validateScienceNumber(String s) {
        int indexOfE = s.indexOf('e');
        if (indexOfE <= 0 || indexOfE == s.length() - 1) {
            return false;
        }
        String prefix = s.substring(0, indexOfE);
        String suffix = s.substring(indexOfE + 1, s.length());
        return (validateOrdinaryNumber(prefix) || validateDecimal(prefix)) && validateOrdinaryNumber(suffix);
    }
}
