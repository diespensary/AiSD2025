import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        double eps = 1e-4;

        double right = 1;
        double left = -right;
        while (f(a, b, c, d, right) * f(a, b, c, d, left) >= 0) {
            right *= 2;
            left = -right;
        }

        double fl = f(a, b, c, d, left);
        while (Math.abs(right - left) > eps) {
            double mid = left + (right - left) / 2;
            double fm = f(a, b, c, d, mid);
            if (fm == 0) {
                break;
            }
            else if (fl * fm < 0) {
                right = mid;
            } else {
                left = mid;
                fl = fm;
            }
        }
        System.out.println(left + (right - left) / 2);
    }

    static double f(int a, int b, int c, int d, double x) {
        return a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d;
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