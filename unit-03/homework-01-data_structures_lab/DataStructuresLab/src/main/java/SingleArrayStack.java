public class SingleArrayStack {
    private final int maxSize;
    private final char[] stackArray;
    private int top;

    public SingleArrayStack(int s) {
        this.maxSize = s;
        this.stackArray = new char[maxSize];
        top = -1;
    }

    public char push(char data) {
        if (top < maxSize - 1) {
            top++;
            stackArray[top] = data;
            return data;
        }
        return 0;
    }

    public char pop() {
        if (top >= 0) {
            return stackArray[top--];
        }
        return 0;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public char top() {
        return stackArray[top];
    }

    public void printStack() {
        if (top >= 0) {
            System.out.println("Elements in stack : ");
            for (int i = 0; i <= top; i++) {
                System.out.println(stackArray[i]);
            }
        }
    }

    /**
     * Return whether an expression's brackets are in correct order with each other or not.
     * @param expression String
     * @return boolean
     */
    public boolean expressionIsValid(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            // Add only acceptable characters { } [ ] ( )
            switch (expression.charAt(i)) {
                case '{':
                case '(':
                case '[':
                    this.push(expression.charAt(i)); // Only add opening brackets to stack
                    break;
                case '}':
                case ')':
                case ']':
                    // Check if stack's top is a match with the closing bracket or not
                    if (!bracketsArePair(this, expression.charAt(i))) return false;
                    break;
            }
        }

        return this.isEmpty(); // Valid if stack is empty at the end
    }

    /**
     * Compare the current top of the stack to the previous closing character to check for valid pairs.
     * @param stack SingleArrayStack
     * @param closingBracket char
     * @return boolean
     */
    public boolean bracketsArePair(SingleArrayStack stack, char closingBracket) {
        if (stack.isEmpty()) return false; // No matching pair available
        stack.printStack();

        char openingBracket = stack.pop();

        switch (openingBracket) {
            case '{':
                if (closingBracket != '}') return false;
                break;
            case '(':
                if (closingBracket != ')') return false;
                break;
            case '[':
                if (closingBracket != ']') return false;
                break;
        }

        return true; // Current match is true.
    }
}