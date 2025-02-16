import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int invers = 0;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] array = new int[n];

        inputArr(array);

        long inversions = mergeSort(array);

        System.out.println(inversions);
        printArr(array);
    }

    public static long mergeSort(int[] array) {
        int arrayLength = array.length;

        if (arrayLength < 2) {
            return 0;
        }

        int midIndex = arrayLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[arrayLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = array[i];
        }

        for (int i = midIndex; i < arrayLength; i++) {
            rightHalf[i - midIndex] = array[i];
        }

        long leftInversions = mergeSort(leftHalf);
        long rightInversions = mergeSort(rightHalf);

        long mergeInversions = merge(array, leftHalf, rightHalf);

        return leftInversions + rightInversions + mergeInversions;
    }

    public static long merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        long inversions = 0;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k] = leftHalf[i];
                i ++;
            } else {
                array[k] = rightHalf[j];
                j++;
                inversions += (leftSize - i);
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }

        return inversions;
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