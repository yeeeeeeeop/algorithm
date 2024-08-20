import java.io.*;
import java.util.*;

class Node {

    int index;
    int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

class Solution {

    public void solve() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 해결
        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Node now = new Node(i, arr[i]);

            while (!deque.isEmpty() && deque.getLast().value > now.value) {
                deque.removeLast();
            }
            deque.addLast(now);

            if (deque.getFirst().index < i - l + 1) {
                deque.removeFirst();
            }
            answer.append(deque.getFirst().value).append(" ");
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
