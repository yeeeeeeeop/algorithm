import java.util.*;
import java.io.*;

class Solution {

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] A = new int[n+1];
        long[] sum = new long[n+1];
        long[] counts = new long[m];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + A[i];
            int remainder = (int) (sum[i] % m);
            if (remainder == 0) {
                answer++;
            }
            counts[remainder]++;
        }

        for (int i = 0; i < m; i++) {
            if (counts[i] >= 2) {
                answer += counts[i] * (counts[i] - 1) / 2;
            }
        }

        System.out.print(answer);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        sol.solve();
    }
}
