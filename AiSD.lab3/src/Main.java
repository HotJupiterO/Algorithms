public class Main {
    public static void main(String[] args) throws FullStackException, EmptyStackException {
        System.out.println("========Initialization block=======");
        SinkingArrayStack<Integer> sStack = new SinkingArrayStack<>(5);
        sStack.push(1);
        sStack.push(2);
        sStack.push(3);
        System.out.println("PLS GOGOGOGO " + sStack.top());
        System.out.println("size: " + sStack.size());
        sStack.cursorDown();
        sStack.top();
        System.out.println("PLS GOGOGOGO " +sStack.peek());
        sStack.push(4);
        sStack.push(5);
        sStack.push(6);
        sStack.push(7);
        System.out.println("size: " + sStack.size());


        System.out.println("===================================");
        sStack.print();

        System.out.println("===================================");
        RPN rpn = new RPN();
        rpn.start();
    }
}
// my first commit
