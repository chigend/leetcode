package tool;

public class ArraySolver {
    public static void main(String[] args) {
        String array = "[[1,1],[2,2],[3,3]]";
        array = array.replaceAll("\\[","{");
        array = array.replaceAll("]","}");
        System.out.println(array);
    }
}
