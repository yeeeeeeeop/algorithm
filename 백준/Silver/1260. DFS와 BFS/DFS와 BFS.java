import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int v;

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            graph[i].sort(null);
        }

        dfs(v);
        visited = new boolean[n+1];
        bfs(v);
        System.out.println(dfsResult);
        System.out.println(bfsResult);
    }

    private static void dfs(int u) {
        if (visited[u]) {
            return;
        }
        visited[u] = true;
        dfsResult.append(u).append(" ");

        for (int v : graph[u]) {
            dfs(v);
        }
    }

    private static void bfs(int u) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(u);
        visited[u] = true;
        while(!queue.isEmpty()) {
            int num = queue.poll();
            bfsResult.append(num).append(" ");
            for (int v : graph[num]) {
                if (visited[v]) {
                    continue;
                }
                queue.add(v);
                visited[v] = true;
            }
        }
    }
}
