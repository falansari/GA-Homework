import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Task 1: Rotate an array
        System.out.println("TASK 1");
        System.out.println("Original Array:");
        ArrayRotation arrayRotation = new ArrayRotation();
        int[] array = {1, 2, 3, 4, 5};
        int[] rotatedArray = arrayRotation.rotate(array, 3);
        System.out.println("Rotated Array:");
        System.out.println(Arrays.toString(rotatedArray));

        // Task 2: Expression Balancing Using Stack
        String expression = "Char {[]} ([ rejotw ])";
        SingleArrayStack stack = new SingleArrayStack(expression.length());
        System.out.println(stack.expressionIsValid(expression));
    }
}
