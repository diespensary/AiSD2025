import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] way = new int[n];

        for (int i = 0; i < n; i++) {
            way[i] = scanner.nextInt();
        }

        int findRailway = 1;
        Stack<Integer> stackWay = new Stack<>();
        List<String> operations = new ArrayList<>();
        int preCountStack = 0;

        for (int index = 0; index < n; index++) {
            int value = way[index];

            if (value == findRailway) {
                int count = index + 1 - preCountStack;
                operations.add("1 " + count);
                for (int i = preCountStack; i <= index; i++) {
                    stackWay.push(way[i]);
                }
                preCountStack = index + 1;

                int indexPreviousElement = stackWay.size() - 2;
                findRailway++;
                int localPullRailway = 1;

                while (findRailway <= n && indexPreviousElement >= 0) {
                    if (stackWay.get(indexPreviousElement) == findRailway) {
                        findRailway++;
                        localPullRailway++;
                        indexPreviousElement--;
                    } else {
                        break;
                    }
                }

                operations.add("2 " + localPullRailway);

                while (localPullRailway > 0) {
                    stackWay.pop();
                    localPullRailway--;
                }
            }
        }

        if (findRailway <= n) {
            System.out.println("0");
        } else {
            System.out.println(operations.size());

            for (String operation : operations) {
                System.out.println(operation);
            }
        }
    }
}