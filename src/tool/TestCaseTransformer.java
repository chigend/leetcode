package tool;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestCaseTransformer {

    public static void main(String[] args) {
        transform("[\"ParkingSystem\", \"addCar\", \"addCar\", \"addCar\", \"addCar\"]\n" +
                "[[1, 1, 0], [1], [2], [3], [1]]","add");
    }

    public static void transform(String s) {
        transform(s, null);
    }

    public static void transform(String s, String printMethodPrefix) {
        String[] split = s.split("\n");
        String[] method = split[0].replaceAll("\\[", "").replaceAll("]", "")
                .replaceAll("\"(.*?)\"", "$1").split(",");
        ;
        String[] arguements = split[1].replaceAll("^\\[(.*)\\]$", "$1").replaceAll("\\[(.*?)\\]", "($1)").split(",");

        StringBuilder sb = new StringBuilder();
        sb.append(method[0]).append(" d").append(" = ").append("new ").append(method[0]).append(arguements[0]).append(";\n");
        for (int i = 1; i < method.length; i++) {
            if (printMethodPrefix != null && method[i].startsWith(printMethodPrefix)) {
                sb.append("System.out.println(");
            }
            sb.append("d.").append(method[i]).append(arguements[i]);
            if (printMethodPrefix != null && method[i].startsWith(printMethodPrefix)) {
                sb.append(")");
            }
            sb.append(";").append("\n");

        }
        System.out.println(sb);
    }

}
