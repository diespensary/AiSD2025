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

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (arrOfNum[mid] < arrOfQue[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left > 0 && arrOfNum[left] != arrOfQue[i] && Math.abs(arrOfQue[i] - arrOfNum[left - 1]) <= Math.abs(arrOfQue[i] - arrOfNum[left])) {
                System.out.println(arrOfNum[left - 1]);
            } else {
                System.out.println(arrOfNum[left]);
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