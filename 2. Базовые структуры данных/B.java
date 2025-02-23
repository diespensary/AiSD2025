// на плюсах ок
// на джаве тл..

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int[] minsInWindows = new int[n - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && array[deque.peekLast()] > array[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                minsInWindows[i - k + 1] = array[deque.peekFirst()];
            }
        }

        for (int i = 0; i < minsInWindows.length; i++) {
            System.out.print(minsInWindows[i] + " ");
        }
    }
}