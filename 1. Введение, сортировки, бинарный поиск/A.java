import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arrOfNum = new int[n];
        inputArr(arrOfNum);

        int[] arrOfQue = new int[k];
        inputArr(arrOfQue);

        for (int i = 0; i < arrOfQue.length; i++) {
            int left = 0;
            int right = n - 1;
            int index = 0;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arrOfNum[mid] < arrOfQue[i]) {
                    left = mid + 1;
                } else if (arrOfNum[mid] > arrOfQue[i]) {
                    right = mid - 1;
                } else if (arrOfNum[mid] == arrOfQue[i]) {
                    index = mid;
                    break;
                }
            }
            if (arrOfNum[index] == arrOfQue[i]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
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