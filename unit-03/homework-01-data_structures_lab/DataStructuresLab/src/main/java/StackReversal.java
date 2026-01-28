import java.util.Stack;

public class StackReversal {
    /**
     * Reverse the contents of a stack.
     * @param stack Stack of Integer
     * @return Stack of Integer
     */
    public Stack<Integer> reverseStack(Stack<Integer> stack) {
        Stack<Integer> reverseStack = new Stack<>();

        while (!stack.empty()) {
            reverseStack.push(stack.pop());
        }

        return reverseStack;
    }
}
