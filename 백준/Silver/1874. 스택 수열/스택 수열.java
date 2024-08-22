import java.io.*;
import java.util.*;

class Solution {

    public void solve() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int num = 1;
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            while (num <= target) {
                answer.append("+\n");
                stack.push(num++);
            }

            int top = stack.pop();
            answer.append("-\n");

            if (top > target) {
                answer = new StringBuilder("NO");
                break;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        sol.solve();
    }
}
