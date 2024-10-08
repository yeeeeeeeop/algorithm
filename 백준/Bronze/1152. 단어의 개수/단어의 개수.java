import java.util.*;
import java.io.*;

class Solution {

    public void solve() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        while (st.hasMoreTokens()) {
            count++;
            st.nextToken();
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
