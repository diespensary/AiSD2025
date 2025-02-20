import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        String str = sc.next();

        TreeMap<Character, Integer> letterCount = new TreeMap<>();
        for (char c : str.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }

        StringBuilder leftPart = new StringBuilder();
        StringBuilder midPart = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            char letter = entry.getKey();
            int count = entry.getValue();

            leftPart.append(String.valueOf(letter).repeat(count / 2));

            letterCount.put(letter, count % 2);
        }

        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                midPart.append(entry.getKey());
                break;
            }
        }

        String palindrome = leftPart.toString() + midPart + leftPart.reverse();

        System.out.println(palindrome);
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