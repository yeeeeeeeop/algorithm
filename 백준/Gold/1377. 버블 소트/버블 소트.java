import java.io.*;
import java.util.Arrays;

class Node implements Comparable<Node> {
    int index;
    int value;

    Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Node node) {
        return this.value - node.value;
    }
}

class Solution {

    public void solve() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
          nodes[i] = new Node(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(nodes);

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nodes[i].index - i);
        }

        System.out.println(max + 1);
    };

}

public class Main {

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        sol.solve();
    }
}
