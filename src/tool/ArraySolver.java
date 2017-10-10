package tool;

public class ArraySolver {
    public static void main(String[] args) {
        String array = "[[9,10],[5,8],[2,6],[1,5],[3,8],[4,9],[8,10],[4,10],[6,8],[7,9]]";
        array = array.replaceAll("\\[","{");
        array = array.replaceAll("]","}");
        System.out.println(array);
    }
}
