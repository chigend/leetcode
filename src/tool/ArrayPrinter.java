package tool;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayPrinter {

    public static <T> void print(T[] res) {
        System.out.println(Arrays.toString(res));
    }

    public static void print(int[] res) {
        System.out.println(Arrays.toString(res));
    }
}
