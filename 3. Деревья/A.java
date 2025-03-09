import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] parentValues = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            parentValues[i] = scanner.nextInt();
        }

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        Node root = nodes[0];
        for (int i = 1; i < n; i++) {
            int parent = parentValues[i - 1];
            nodes[parent].children.add(nodes[i]);
        }

        Result result = heightDiameter(root, 0);
        int height = result.height;
        int diameter = result.diameter;

        int[] depths = new int[n];
        findDepths(root, 0, depths);

        System.out.println(height + " " + diameter);
        for (int depth : depths) {
            System.out.print(depth + " ");
        }
    }

    static class Result {
        int height;
        int diameter;

        public Result(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static Result heightDiameter(Node node, int depth) {
        if (node == null) {
            return new Result(depth, 0);
        }

        int maxHeight = depth;
        int maxDiameter = 0;
        int[] maxChildHeights = {0, 0};

        for (Node child : node.children) {
            Result childResult = heightDiameter(child, depth + 1);
            maxHeight = Math.max(maxHeight, childResult.height);
            maxDiameter = Math.max(maxDiameter, childResult.diameter);

            if (childResult.height > maxChildHeights[0]) {
                maxChildHeights[1] = maxChildHeights[0];
                maxChildHeights[0] = childResult.height;
            } else if (childResult.height > maxChildHeights[1]) {
                maxChildHeights[1] = childResult.height;
            }
        }

        maxDiameter = Math.max(maxDiameter, maxChildHeights[0] + maxChildHeights[1] - 2 * depth);

        return new Result(maxHeight, maxDiameter);
    }

    public static void findDepths(Node node, int depth, int[] depths) {
        depths[node.value] = depth;
        for (Node child : node.children) {
            findDepths(child, depth + 1, depths);
        }
    }
}

class Node {
    int value;
    List<Node> children;

    public Node(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}