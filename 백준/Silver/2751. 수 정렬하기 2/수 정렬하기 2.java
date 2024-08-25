import java.io.*;
import java.util.*;

class Solution {

    public void solve() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            answer.append(nums[i]).append("\n");
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
