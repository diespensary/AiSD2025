import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] parents = reader.readLine().split(" ");
        Node[] nodes = new Node[n];
        nodes[0] = new Node(null, 0);

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(parents[i - 1]);
            Node parent = nodes[num];
            nodes[i] = new Node(parent, i);
        }

        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {
            String[] uv = reader.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            
            int result = findFirstCommonNode(nodes[u], nodes[v]);
            
            System.out.println(result);
        }
    }

    static int findFirstCommonNode(Node nodeA, Node nodeB) {
        Set<Integer> visitedA = new HashSet<>();
        Set<Integer> visitedB = new HashSet<>();

        while (nodeA.parent != null || nodeB.parent != null) {
            if (nodeA.parent != null) {
                if (visitedB.contains(nodeA.num)) {
                    return nodeA.num;
                }
                visitedA.add(nodeA.num);
                nodeA = nodeA.parent;
            }
            if (nodeB.parent != null) {
                if (visitedA.contains(nodeB.num)) {
                    return nodeB.num;
                }
                visitedB.add(nodeB.num);
                nodeB = nodeB.parent;
            }
        }

        return 0;
    }
}

class Node {
    Node parent;
    int num;

    public Node(Node parent, int num) {
        this.parent = parent;
        this.num = num;
    }
}