package validate_ip_address;

public class Solution {
    public static void main(String[] args) {
        String ip = validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334");
        System.out.println(ip);
    }

    public static String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        }
        if (isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private static boolean isIPv4(String IP) {
        if (IP.startsWith(".") || IP.endsWith(".")) {
            return false;
        }
        String[] parts = IP.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        for (int i = 0; i < parts.length; i++) {
            if (!isValidIPv4Num(parts[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidIPv4Num(String numStr) {
        //empty or to long
        if (numStr.length() == 0 || numStr.length() > 3) {
            return false;
        }
        char[] chars = numStr.toCharArray();
        //contain non-numeric letter
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                return false;
            }
        }
        //contain leading zero
        int num = Integer.valueOf(numStr);
        if (String.valueOf(num).length() != numStr.length()) {
            return false;
        }
        if (num > 255) {
            return false;
        }
        return true;
    }

    private static boolean isIPv6(String IP) {
        if (IP.startsWith(":") || IP.endsWith(":")) {
            return false;
        }
        String[] parts = IP.split(":");
        if (parts.length != 8) {
            return false;
        }
        for (int i = 0; i < parts.length; i++) {
            if (!isValidHexadecimalDigits(parts[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidHexadecimalDigits(String str) {
        //empty or extra digits
        if (str.length() == 0 || str.length() > 4) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char c = chars[i];
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                return false;
            }
        }
        return true;
    }
}
