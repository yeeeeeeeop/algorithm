import java.io.*;
import java.util.StringTokenizer;

class Solution {
    int N;
    int max;
    int[] scores;

    Solution(int N, int[] arr) {
        this.N = N;
        this.scores = arr;
    }

    public double solve() {
        findMax();

        double total = 0;
        for (int i = 0; i < N; i++) {
            total += adjust(scores[i]);
        }

        return total / N;
    }

    private void findMax() {
        int max = scores[0];
        for (int i = 1; i < N; i++) {
            if (max < scores[i]) {
                max = scores[i];
            }
        }
        this.max = max;
    }

    private double adjust(int score) {
        return (double) score / max * 100;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 해결
        Solution sol = new Solution(N, arr);
        double answer = sol.solve();
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
    }
}
