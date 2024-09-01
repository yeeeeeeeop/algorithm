import java.util.*;

public class Main {

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    static int n;
    static int m;
    static int[][] matrix;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        matrix = new int[n+2][m+2];
        visited = new boolean[n+2][m+2];
        
        for (int row = 1; row <= n; row++) {
            String line = sc.nextLine();
            String[] split = line.split("");
            for (int col = 1; col <= m; col++) {
                matrix[row][col] = Integer.parseInt(split[col - 1]);
            }
        }

        bfs();
        System.out.print(matrix[n][m]);
    }

    private static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();

        queue.add(new Point(1, 1));
        visited[1][1] = true;
        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            if (curr.row == n && curr.col == m) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = curr.row + dy[i];
                int nextCol = curr.col + dx[i];
                if (!visited[nextRow][nextCol] && matrix[nextRow][nextCol] == 1) {
                    queue.add(new Point(nextRow, nextCol));
                    matrix[nextRow][nextCol] = matrix[curr.row][curr.col] + 1;
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
