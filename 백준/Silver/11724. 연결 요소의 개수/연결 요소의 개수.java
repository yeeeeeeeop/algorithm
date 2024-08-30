import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());
        int count = 0;

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(input.nextToken());
            int v = Integer.parseInt(input.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            boolean result = dfs(i);
            if (result) count++;
        }

        System.out.println(count);
    }

    static boolean dfs(int start) {
        if (visited[start]) {
            return false;
        }

        visited[start] = true;
        while (!graph[start].isEmpty()) {
            int end = graph[start].remove(0);
            dfs(end);
        }

        return true;
    }
}
