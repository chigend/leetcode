package tool;

public class ArrayTestCaseTransformer {

    public static int[] transform(String array) {
        String[] numbers = array.replaceAll("\\[", "").replaceAll("]", "").split(",");
        int[] results = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            results[i] = new Integer(numbers[i]);
        }
        return results;
    }

    public static String[] transformString(String array) {
        String[] strings = array.replaceAll("\\[", "").
                replaceAll("\"", "").replaceAll("]", "").split(",");

        return strings;
    }

}
