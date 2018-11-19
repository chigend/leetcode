package long_pressed_name;

public class Solution2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean longPressed = solution.isLongPressedName("laidez", "laideccc");
        System.out.println(longPressed);

    }
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        char[] nameChars = name.toCharArray();
        char[] typedChars = typed.toCharArray();
        while (i < name.length() && j < typed.length()) {
            if (nameChars[i] == typedChars[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == name.length();
    }
}
