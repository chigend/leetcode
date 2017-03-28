package simplify_path;

/**
 * @author yejinbiao
 * @create 2017-03-28-下午3:55
 */

public class Solution {
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        path = simplifyPath(path);
        System.out.println(path);
    }

    public static String simplifyPath(String path) {
        String [] directorys = path.split("/");
        String [] stack = new String[directorys.length];
        int top = 0;
        for (int i = 0; i < directorys.length; i++) {
            String directory = directorys[i];
            if ("".equals(directory) || ".".equals(directory)) continue;
            if ("..".equals(directory)) {
                if (top > 0) top--;
            } else stack[top++] = directory;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < top; i++) {
            sb.append("/").append(stack[i]);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
