import java.io.*;
import java.util.*;

class Solution {

    int[] minCounts;
    int[] counts;

    public void solve() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] dna = br.readLine().toCharArray();
        minCounts = new int[4];
        counts = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minCounts[i] = Integer.parseInt(st.nextToken());
        }

        // 해결
        for (int i = 0; i < p; i++) {
            counts[getIndex(dna[i])]++;
        }
        if (checkPassword()) answer++;
        
        for (int left = 1, right = left + p - 1; right < s; left++, right++) {
            counts[getIndex(dna[left-1])]--;
            counts[getIndex(dna[right])]++;
            if (checkPassword()) answer++;
        }

        System.out.print(answer);
    }

    private int getIndex(char ch) {
        switch (ch) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: return -1;
        }
    }

    private boolean checkPassword() {
        for (int i = 0; i < 4; i++) {
            if (minCounts[i] > counts[i]) {
                return false;
            }
        }
        return true;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        sol.solve();
    }
}
