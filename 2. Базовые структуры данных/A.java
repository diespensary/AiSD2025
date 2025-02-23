// на джаве тл
// на плюсах ок

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int command = sc.nextInt();
            if (command == 1) {
                int num = sc.nextInt();
                myStack.push(num);
            } else if (command == 2) {
                myStack.pop();
            } else if (command == 3) {
                System.out.println(myStack.getMin());
            }
        }

    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void inputArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }
}

class MyStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    MyStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    int pop() {
        int topNum = stack.pop();
        if (minStack.peek() == topNum) {
            minStack.pop();
        }
        return topNum;
    }

    int getMin() {
        return minStack.peek();
    }
}