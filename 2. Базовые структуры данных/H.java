import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prevLeft = new int[n];
        Arrays.fill(prevLeft, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prevLeft[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] prevRight = new int[n];
        Arrays.fill(prevRight, n);
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prevRight[i] = stack.peek();
            }
            stack.push(i);
        }

        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            int left = prevLeft[i] + 1;
            int right = prevRight[i] - 1;

            maxSum = Math.max(maxSum, arr[i] * (prefixSum[right + 1] - prefixSum[left]));
        }

        System.out.println(maxSum);
    }
}