import java.math.BigDecimal;

public class Calculator {
    private static int calculations_count = 0;
    //protected static BigDecimal last_result = new BigDecimal("0");
    protected static int last_result = 0;
    public static String calculator_name = "My Simple Calculator";

    public static void main (String[] args) {
        System.out.println("add: " + add(5, 10));
        System.out.println("subtract: " + subtract(16, 4));
        showLastResult(last_result);
        showTotalCalculations();
        monthlyReset();
        showLastResult(last_result);
    }

    public static int add(int a, int b) {
        int sum = a + b;
        last_result = sum;
        calculations_count++;

        return sum;
    }

    protected static int subtract(int a, int b) {
        int sum = a - b;
        last_result = sum;
        calculations_count++;

        return sum;
    }

    private static void resetCalculator() {
        last_result = 0;
    }

    public static void monthlyReset() {
        System.out.println("Reset the calculator.");
        resetCalculator();
    }

    static void showTotalCalculations() {
        System.out.println("Total number of calculations done: " + calculations_count + ".");
    }

    public static void showLastResult(int last_result) {
        System.out.println("Latest calculation result: " + last_result);
    }
}
