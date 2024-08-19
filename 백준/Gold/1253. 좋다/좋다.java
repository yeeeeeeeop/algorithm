import java.util.*;
import java.io.*;

class Solution {

    public void solve() throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 해결
        Arrays.sort(num);
        int count = 0;
        for (int i = 0; i < n; i++) {
            int standard = num[i];
            int left = 0;
            int right = n - 1;
            while (left < right) {
                // 본인 제외
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = num[left] + num[right];
                if (sum < standard) {
                    left++;
                } else if (sum > standard) {
                    right--;
                } else {
                    count++;
                    break;
                }
            }
        }

        System.out.print(count);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        sol.solve();
    }
}
