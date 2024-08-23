import java.util.*;

class Solution {

    public void solve() {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.print(queue.poll());
    }
}

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solve();
    }
}
