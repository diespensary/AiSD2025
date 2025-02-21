import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = sc.nextInt();
        }

        int[] iterations = new int[n + 1];
        iterations[0] = 1;

        HashSet<Integer> positionsWithoutLasts = new HashSet<>();
        int countWithoutLasts = 0;
        int N = n;
        for (int i = 0; i < n; i++) {
            int pos = positions[i];
            positionsWithoutLasts.add(pos);
            countWithoutLasts++;

            while (positionsWithoutLasts.contains(N)) {
                positionsWithoutLasts.remove(N);
                countWithoutLasts--;
                N--;
            }

            iterations[i + 1] = countWithoutLasts + 1;
        }

        printArr(iterations);
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