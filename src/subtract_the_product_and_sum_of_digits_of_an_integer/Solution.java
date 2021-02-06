package subtract_the_product_and_sum_of_digits_of_an_integer;

public class Solution {

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
        System.out.println(subtractProductAndSum(4421));
        System.out.println(subtractProductAndSum(9999));

    }

    public static int subtractProductAndSum(int n) {
        int product = 1;

        int sum = 0;

        while (n != 0) {
            int d = n % 10;
            n /= 10;
            product *= d;
            sum += d;
        }
        return product - sum;
    }
}
