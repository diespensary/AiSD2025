import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> heap = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("0")) {
                int x = Integer.parseInt(input[1]);
                insert(heap, x);
            } else {
                System.out.println(extract(heap));
            }
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