import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> leftHalfOfQueue = new ArrayDeque<>();
        ArrayDeque<Integer> rightHalfOfQueue = new ArrayDeque<>();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            String operation = line[0];

            if (leftHalfOfQueue.size() > rightHalfOfQueue.size()) {
                rightHalfOfQueue.addLast(leftHalfOfQueue.pollFirst());
            }

            if (operation.equals("+")) {
                int id = Integer.parseInt(line[1]);
                leftHalfOfQueue.addLast(id);
            } else if (operation.equals("*")) {
                int id = Integer.parseInt(line[1]);
                leftHalfOfQueue.addFirst(id);
            } else {
                int id = rightHalfOfQueue.pollFirst();
                result.append(id + "\n");
            }
        }

        System.out.println(result);

        reader.close();
    }
}