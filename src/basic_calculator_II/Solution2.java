package basic_calculator_II;

public class Solution2 {
    public static void main(String[] args) {
        int res = calculate("2*34/3+2*3");
        System.out.println(res);
    }

    public static int calculate(String s) {
        s = s.replaceAll(" ","");
        String[] operands = s.split("[+\\-*/]");
        String[] operators = s.split("\\d+");
        if (operators.length == 0) {
            return Integer.valueOf(operands[0]);
        }
        int i = 0;
        operators[0] = "+";
        int res = 0;
        String operator = "+";
        while (i < operators.length) {
            while (i < operators.length && low(operators[i]) && (i == operators.length - 1 || low(operators[i + 1]))) {
                res = calc(res, Integer.parseInt(operands[i]), operators[i]);
                i++;
            }
            if (i == operators.length) {
                break;
            }
            operator = operators[i];
            int temp = Integer.parseInt(operands[i]);
            while (++i < operators.length && high(operators[i])) {
                temp = calc(temp, Integer.valueOf(operands[i]), operators[i]);
            }
            res = calc(res, temp, operator);
        }
        return res;
    }

    private static boolean low(String operator) {
        return "+".equals(operator) || "-".equals(operator);
    }

    private static boolean high(String operator){
        return "*".equals(operator) || "/".equals(operator);
    }
    public static int calc(int num1, int num2, String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
            default:
                break;
        }
        return result;
    }
}
