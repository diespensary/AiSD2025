import java.util.Stack;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt();
        }

        Stack<Balloon> stack = new Stack<>();

        int result = 0;
        int i = 0;
        while (i < n) {
            int color = colors[i];

            if (stack.isEmpty() || stack.peek().color != colors[i]) {
                stack.push(new Balloon(color, 1));
            } else {
                stack.peek().count++;
            }

            if (stack.peek().count >= 3) {
                int j = i + 1;
                while (j < n && colors[j] == color) {
                    stack.peek().count++;
                    j++;
                }

                result += stack.peek().count;

                if (!stack.isEmpty() && stack.peek().count >= 3) {
                    stack.pop();
                }

                i = j - 1;
            }

            i++;
        }

        System.out.println(result);
    }
}

class Balloon {
    int color;
    int count;

    public Balloon(int color, int count) {
        this.color = color;
        this.count = count;
    }
}