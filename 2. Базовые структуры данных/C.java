import java.util.Stack;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] postfix = sc.nextLine().split(" ");

        Stack<Integer> stack = new Stack<>();
        for (String str : postfix) {
            if (isNumeric(str)) {
                stack.push(Integer.parseInt(str));
            } else {
                int y = stack.pop();
                int x = stack.pop();

                switch (str) {
                    case "+":
                        stack.push(x + y);
                        break;
                    case "-":
                        stack.push(x - y);
                        break;
                    case "*":
                        stack.push(x * y);
                        break;
                }
            }
        }

        System.out.println(stack.peek());
    }

    static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}