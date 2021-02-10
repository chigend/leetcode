package delete_columns_to_make_sorted;

public class Solution {

    public static void main(String[] args) {

    }

    public int minDeletionSize(String[] strs) {

        int column = strs[0].length();

        int delete = 0;
        for(int i = 0; i < column; i++) {
            for(int j = 1; j< strs.length;j++) {
                if(strs[j].charAt(i) < strs[j-1].charAt(i)) {
                    delete++;
                    break;
                }
            }
        }
        return delete;
    }
}
