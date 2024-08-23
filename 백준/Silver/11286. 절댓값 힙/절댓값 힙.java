import java.io.*;
import java.util.*;

class Solution {

    public void solve() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(this::compare);

        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(br.readLine());

            if (curr == 0) {
                int data = pq.isEmpty() ? 0 : pq.poll();
                answer.append(data).append("\n");
            } else {
                pq.add(curr);
            }
        }

        System.out.print(answer);
    }

    private int compare(Integer o1, Integer o2) {
        int first_abs = Math.abs(o1);
        int second_abs = Math.abs(o2);
        if (first_abs == second_abs) {
            return o1 > o2 ? 1 : -1;
        } else {
            return first_abs - second_abs;
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        sol.solve();
    }
}
