import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());

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
            if (!visited[i]) count++;
            dfs(i);
        }

        System.out.println(count);
    }

    static void dfs(int start) {
        if (visited[start]) {
            return;
        }

        visited[start] = true;
        for (int num : graph[start]) {
            dfs(num);
        }
    }
}
