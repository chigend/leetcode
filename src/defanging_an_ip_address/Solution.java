package defanging_an_ip_address;

public class Solution {

    public static void main(String[] args) {

    }

    public String defangIPaddr(String address) {

        StringBuilder sb = new StringBuilder();
        char[] chars = address.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                sb.append("[.]");
            }else {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }
}
