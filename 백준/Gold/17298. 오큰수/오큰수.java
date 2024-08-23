import java.io.*;
import java.util.*;

class Solution {

    public void solve() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] nge = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>(); // 인덱스가 들어있는 스택
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.empty() && arr[i] > arr[stack.peek()]) {
                nge[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.empty()) {
            nge[stack.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            answer.append(nge[i]).append(" ");
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
