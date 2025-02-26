import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        HashMap<Integer, Integer> queueHistory = new HashMap<>();

        StringBuilder result = new StringBuilder();
        int deleted = 0;
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            int operation = Integer.parseInt(input[0]);

            if (operation == 1) {
                int id = Integer.parseInt(input[1]);
                queueHistory.put(id, queue.size() + deleted);
                queue.addLast(id);
            } else if (operation == 2) {
                queue.pollFirst();
                deleted++;
            } else if (operation == 3) {
                queue.pollLast();
            } else if (operation == 4) {
                int q = Integer.parseInt(input[1]);
                result.append(queueHistory.get(q) - deleted).append("\n");
            } else {
                result.append(queue.peekFirst()).append("\n");
            }
        }

        System.out.print(result);
        reader.close();
    }
}