import java.util.*;
import java.io.*;

public class Main {

    static int V;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] depth;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        visited = new boolean[V+1];
        depth = new int[V+1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());

            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                graph[u].add(new Node(v, weight));
            }
        }

        bfs(1);
        int maxIndex = findMax()[1];
        bfs(maxIndex);
        int max = findMax()[0];
        System.out.println(max);

    }

    static class Node {
        int v;
        int weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    private static void bfs(int start) {
        Queue<Node> queue = new ArrayDeque<>();
        Arrays.fill(visited, false);
        Arrays.fill(depth, 0);

        queue.add(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node peek = queue.poll();
            for (Node node : graph[peek.v]) {
                if (!visited[node.v]) {
                    visited[node.v] = true;
                    queue.add(node);
                    depth[node.v] = depth[peek.v] + node.weight;
                }
            }
        }
    }

    private static int[] findMax() {
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i <= V; i++) {
            if (max < depth[i]) {
                maxIndex = i;
                max = depth[i];
            }
        }

        return new int[]{max, maxIndex};
    }
}
