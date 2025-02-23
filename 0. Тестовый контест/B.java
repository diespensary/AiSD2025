import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n + 1];
        a[0] = 1;

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        if (k == n) {
            System.out.println(a[k]);
            return;
        }
        if (a[k] != a[k + 1]) {
            System.out.println(a[k]);
        } else {
            System.out.println(-1);
        }
    }
}