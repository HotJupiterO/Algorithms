import java.util.Scanner;
import java.util.Stack;

/**
 * Reverse Polish notation (RPN) is a mathematical notation in which operators follow
 * their operands, in contrast to Polish notation (PN), in which operators precede their operands.
 * It does not need any parentheses as long as each operator has a fixed number of operands.
 * The description "Polish" refers to the nationality of logician Jan Łukasiewicz,who invented Polish notation in 1924.
 */
public class RPN {
    private static Stack<Integer> stack = new Stack<>();
    private static Scanner input = new Scanner(System.in);
    private static String nextSymbol = " ";

    /**
     * Start RPN calculator.
     * <i> For example:</i>
     * <p><b>in postfix notation:</b>
     * 2 3 4 + * = 14</p>
     *
     * <b>in infix notation:</b>
     * (3 + 4) * 2 = 14
     */
    public void start() {
        Integer a, b;
        System.out.println("Enter 'exit' for stop the program or 'clear' to clear stack");
        while (!nextSymbol.equals("exit")) {
            System.out.println("Enter next symbol: ");
            nextSymbol = input.next();
            try {
                int digit = Integer.valueOf(nextSymbol);
                stack.push(digit);
            } catch (NumberFormatException e) {
                switch (nextSymbol) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b-a);
                        break;
                    case "*":
                    case "x":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        a = stack.pop();
                        b = stack.pop();
                        if (b != 0) {
                            stack.push(a / b);
                        } else throw new ArithmeticException("Divide by zero. The program has ended with exception");
                        break;
                    case "=":
                        System.out.println(stack.peek());
                        break;
                    case "clear":
                        for (int i = 0; i < stack.size(); i++) {
                            stack.pop();
                        }
                        break;
                    default:
                        if (!nextSymbol.equals("exit")) {
                            System.out.println("Please enter digits or '+', '-', '* or x', '/'");
                        }
                }
            }
        }
    }
}