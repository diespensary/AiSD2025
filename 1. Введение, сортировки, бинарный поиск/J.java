import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            long m = scanner.nextLong();
            findOrientation(n, m);
        }
    }

    public static void findOrientation(long n, long m) {
        long[] horizontalResult = binarySearch(1, n, "H", m, n);
        long[] verticalResult = binarySearch(1, m, "V", m, n);

        if (Math.abs(horizontalResult[0]) < Math.abs(verticalResult[0])) {
            System.out.println("H " + (int) horizontalResult[1]);
        } else {
            System.out.println("V " + (int) verticalResult[1]);
        }
    }

    public static long arithmeticProgression(long a, long k, long n) {
        return (2 * a + k * (n - 1)) * n / 2;
    }

    public static long horizontalDifference(long y, long m, long n) {
        long top = arithmeticProgression(1, 1, m * (y - 1));
        long total = arithmeticProgression(1, 1, m * n);
        long bottom = total - top;
        return top - bottom;
    }

    public static long verticalDifference(long x, long m, long n) {
        long left = n * arithmeticProgression(0, 1, x - 1) + (x - 1) * arithmeticProgression(1, m, n);
        long total = arithmeticProgression(1, 1, m * n);
        long right = total - left;
        return left - right;
    }

    public static long[] binarySearch(long left, long right, String positionType, long m, long n) {
        long mid = (left + right) / 2;
        long diffMid = positionType.equals("H") ? horizontalDifference(mid, m, n) : verticalDifference(mid, m, n);

        if (right - left <= 1) {
            long diffLeft = positionType.equals("H") ? horizontalDifference(left, m, n) : verticalDifference(left, m, n);
            long diffRight = positionType.equals("H") ? horizontalDifference(right, m, n) : verticalDifference(right, m, n);

            if (Math.abs(diffLeft) > Math.abs(diffRight)) {
                return new long[]{diffRight, right};
            } else {
                return new long[]{diffLeft, left};
            }
        }

        if (diffMid > 0) {
            return binarySearch(left, mid, positionType, m, n);
        } else {
            return binarySearch(mid, right, positionType, m, n);
        }
    }
}