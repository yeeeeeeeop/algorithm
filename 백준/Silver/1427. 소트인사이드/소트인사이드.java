import java.util.*;

class Solution {

    public void solve() {

        Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();

        char[] input = sc.nextLine().toCharArray();
        int[] num = new int[input.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) input[i] - '0';
        }

        for (int i = 0; i < num.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[maxIndex] < num[j]) {
                    maxIndex = j;
                }
            }
            int tmp = num[i];
            num[i] = num[maxIndex];
            num[maxIndex] = tmp;
        }

        for (int n : num) {
            answer.append(n);
        }

        System.out.print(answer);
    }
}

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solve();
    }
}
