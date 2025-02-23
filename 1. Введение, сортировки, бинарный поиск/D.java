import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double c = sc.nextDouble();
        double eps = 1e-6;

        double left = -1;
        double right = c;
        double mid = left + (right - left) / 2;
        while (Math.abs(f(mid) - c) > eps) {
            if (f(mid) > c) {
                right = mid;
            } else {
                left = mid;
            }
            mid = left + (right - left) / 2;
        }
        System.out.println(mid);
    }

    static double f(double x) {
        return Math.pow(x, 2) + Math.sqrt(x + 1);
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