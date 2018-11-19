package long_pressed_name;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean longPressed = solution.isLongPressedName("laidec", "laideccc");
        System.out.println(longPressed);
    }

    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) {
            return false;
        }
        int i = 0, j = 0;
        char[] nameChars = name.toCharArray();
        char[] typedChars = typed.toCharArray();
        while (i < name.length() && j < typed.length()) {
            char nameChar = nameChars[i];
            char typedChar = typedChars[j];
            if (nameChar != typedChar) {
                return false;
            }
            int countNameChar = 1;
            while (++i < name.length() && nameChars[i] == nameChar) {
                countNameChar++;
            }
            int countTypedChar = 1;
            while (++j < typed.length() && typedChars[j] == typedChar) {
                countTypedChar++;
            }
            if (countTypedChar < countNameChar) {
                return false;
            }
        }
        return i == name.length() && j == typed.length();
    }

}
