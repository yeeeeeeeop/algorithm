import java.util.Scanner;

class Solution {
    
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int start = 1;
        int end = 1;
        int count = 0;
        
        while (end <= n) {
            int sum = getPrefixSum(start, end);
            if (sum > n) {
                start++;
            } else if (sum < n) {
                end++;
            } else {
                end++;
                count++;
            }
        }
        
        System.out.print(count);
    }
    
    private int getPrefixSum(int a, int b) {
        return (b + a) * (b - a + 1) / 2;
    }
}

public class Main {
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solve();
    }
}
