package valid_boomerang;

public class Solution {
    public static void main(String[] args) {
        int[][] a = {{0, 0}, {1, 1}, {1, 1}};

        boolean boomerang = isBoomerang(a);
        System.out.println(boomerang);
    }

    public static boolean isBoomerang(int[][] points) {

        if (points[0][0] == points[1][0] && points[0][1] == points[1][1]
                || points[1][0] == points[2][0] && points[1][1] == points[2][1]
                || points[0][0] == points[2][0] && points[0][1] == points[2][1]) {
            return false;
        }
        double k1 = calculateK(points[0][0], points[0][1], points[1][0], points[1][1]);

        double k2 = calculateK(points[1][0], points[1][1], points[2][0], points[2][1]);

        return k1 != k2;
    }

    public static double calculateK(int x1, int y1, int x2, int y2) {
        if (y1 == y2) {
            return 0;
        }

        if (x1 == x2) {
            return Integer.MAX_VALUE;
        }

        return (double) (y2 - y1) / (x2 - x1);
    }
}
