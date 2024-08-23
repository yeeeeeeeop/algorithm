import java.util.*;

class Solution {

    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }

        while (queue.size() > 1) {
            queue.removeFirst();
            queue.addLast(queue.removeFirst());
        }

        System.out.print(queue.removeFirst());
    }
}

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solve();
    }
}
