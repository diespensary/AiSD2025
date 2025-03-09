import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> heap = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            insert(heap, arr[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = extract(heap);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void insert(ArrayList<Integer> heap, int x) {
        heap.add(x);
        int i = heap.size() - 1;
        while (i > 0 && heap.get((i - 1) / 2) < heap.get(i)) {
            int parent = (i - 1) / 2;
            int temp = heap.get(parent);
            heap.set(parent, heap.get(i));
            heap.set(i, temp);
            i = parent;
        }
    }

    static int extract(ArrayList<Integer> heap) {
        int max = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int i = 0;
        while (2 * i + 1 < heap.size()) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int j = left;

            if (right < heap.size() && heap.get(right) > heap.get(left)) {
                j = right;
            }
            if (heap.get(i) >= heap.get(j)) {
                break;
            }

            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
            i = j;
        }

        return max;
    }
}