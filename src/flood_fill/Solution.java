package flood_fill;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill(image, 1, 1, 1);
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private static void fill(int[][] image, int sr, int sc, int start, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        if (image[sr][sc] == start) {
            image[sr][sc] = newColor;
            fill(image, sr - 1, sc, start, newColor);
            fill(image, sr + 1, sc, start, newColor);
            fill(image, sr, sc - 1, start, newColor);
            fill(image, sr, sc + 1, start, newColor);
        }
    }
}
