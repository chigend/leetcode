package find_duplicate_file_in_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Follow up questions:

 1. Imagine you are given a real file system, how will you search files? DFS or BFS ?
 In general, BFS will use more memory then DFS. However BFS can take advantage of the locality of files in inside directories, and therefore will probably be faster

 2. If the file content is very large (GB level), how will you modify your solution?
 In a real life solution we will not hash the entire file content, since it's not practical. Instead we will first map all the files according to size. Files with different sizes are guaranteed to be different. We will than hash a small part of the files with equal sizes (using MD5 for example). Only if the md5 is the same, we will compare the files byte by byte

 3. If you can only read the file by 1kb each time, how will you modify your solution?
 This won't change the solution. We can create the hash from the 1kb chunks, and then read the entire file if a full byte by byte comparison is required.

 What is the time complexity of your modified solution? What is the most time consuming part and memory consuming part of it? How to optimize?
 Time complexity is O(n^2 * k) since in worse case we might need to compare every file to all others. k is the file size

 How to make sure the duplicated files you find are not false positive?
 We will use several filters to compare: File size, Hash and byte by byte comparisons.
 */
public class Solution {
    public static void main(String[] args) {
        List<List<String>> result = findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"});
        System.out.println(result);
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            for (int i = 1; i < files.length; i++) {
                String file = files[i];
                int leftBrakets = file.indexOf('(');
                String content = file.substring(leftBrakets + 1, file.length() - 1);
                List<String> group = map.getOrDefault(content, new ArrayList<>());
                group.add(files[0]+"/"+file.substring(0, leftBrakets));
                map.put(content, group);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : map.values()) {
            if (group.size() > 1) {
                result.add(group);
            }
        }
        return result;
    }
}
