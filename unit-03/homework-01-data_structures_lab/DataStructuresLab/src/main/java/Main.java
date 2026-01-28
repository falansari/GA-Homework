import java.util.Arrays;
import java.util.Stack;

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
        System.out.println(" ");

        // Task 2: Expression Balancing Using Stack
        System.out.println("TASK 2");
        String expression = "Char {[]} ([ rejotw ])";
        SingleArrayStack singleArrayStack = new SingleArrayStack(expression.length());
        System.out.println(singleArrayStack.expressionIsValid(expression));
        System.out.println(" ");

        // Task 3: Reverse a stack
        System.out.println("TASK 3");
        int[] stackDigits = {1, 2, 3, 4, 5};
        Stack<Integer> stack = new Stack<>();

        // Add array contents into stack
        for (int stackDigit : stackDigits) {
            stack.push(stackDigit);
        }

        System.out.println("Original Stack: ");
        for (int stackDigit : stackDigits) {
            System.out.print(stack.search(stackDigit) + " ");
        }
        System.out.println(" ");

        System.out.println("Reversed Stack: ");
        StackReversal stackReversal = new StackReversal();
        stack = stackReversal.reverseStack(stack);

        for (int stackDigit : stackDigits) {
            System.out.print(stack.search(stackDigit) + " ");
        }

        System.out.println(" ");
    }
}
