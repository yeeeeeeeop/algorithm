import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer = 0;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 1);
        }

        System.out.print(answer);
    }

    private static void dfs(int num, int depth) {
        if (visited[num]) {
            return;
        }
        visited[num] = true;

        if (depth == 5) {
            answer = 1;
            return;
        }

        for (Integer next : graph[num]) {
            dfs(next, depth + 1);
        }
        visited[num] = false;
    }
}
