import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] num = new int[n+1][n+1];
        int[][] sum = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            num[i][0] = num[0][i] = sum[i][0] = sum[0][i] = 0;
        }
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가로구간합 구하기
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                sum[i][j] = sum[i][j-1] + num[i][j];
            }
        }

        // 답 구하기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int total = 0;
            for (int row = x1; row <= x2; row++) {
                total += (sum[row][y2] - sum[row][y1-1]);
            }

            answer.append(total).append("\n");
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
