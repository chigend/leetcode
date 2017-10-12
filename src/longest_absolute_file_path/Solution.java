package longest_absolute_file_path;

public class Solution {
    public static void main(String[] args) {

    }

    public static int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] levels = new int[paths.length + 1];
        int curLen = 0;
        int maxLen = 0;
        for (String path : paths) {
            /**
             * since the path start with '\t', the lastIndex of '\t' plus 1
             * will be the count of \t,also can be considered as directory
             * level,e.g  if there are no '\t',means it is the root directory
             * if there are 1 '\t', it means the current path is the second
             * level directory like dir\n\tfile.ext
             * dir
             *      file.ext
             *  and the current level's length will be last level's length
             *  plus current path's length and exclude the '\t' prefix length
             *  and plus '\' the slash length,counted as 1
             */

            int level = path.lastIndexOf('\t') + 1;
            curLen = levels[level + 1] = levels[level] + path.length() - level + 1;
            if (path.contains(".")) {
                //if current path is a file, we record it.
                maxLen = Math.max(maxLen, curLen - 1);
            }
        }
        return maxLen;
    }
}
