import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static String query(int x) {
        System.out.flush();
        System.out.println(x);
        System.out.flush();
        return sc.next();
    }

    public static void main(String[] args) {
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println("! " + n);
            return;
        }

        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String answer = query(mid);
            if (answer.equals("<")) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println("! " + right);
        System.out.flush();
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