import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Integer, Node> mapTree = new HashMap<>();
    static int[] mapHeightNode;
    static boolean success = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int root = scanner.nextInt();

        mapHeightNode = new int[n];

        mapTree.put(-1, new Node(-1, -1));

        for (int valNode = 0; valNode < n; valNode++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            if ((left != -1 && left > valNode) || (right != -1 && right < valNode)) {
                success = false;
            }

            mapTree.put(valNode, new Node(left, right));
        }

        if (success) {
            calculateHeightNode(root);
        }

        System.out.println(success ? 1 : 0);
    }

    public static int calculateHeightNode(int valNode) {
        Node node = mapTree.get(valNode);
        if (node.left == -1 && node.right == -1) {
            return 0;
        }

        int heightLeftNode = 0;
        if (node.left != -1) {
            heightLeftNode = calculateHeightNode(node.left);
        }

        int heightRightNode = 0;
        if (node.right != -1) {
            heightRightNode = calculateHeightNode(node.right);
        }

        if (Math.abs(heightLeftNode - heightRightNode) > 1) {
            success = false;
        }

        mapHeightNode[valNode] = Math.max(heightLeftNode, heightRightNode) + 1;
        return mapHeightNode[valNode];
    }
}

class Node {
    int left;
    int right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}