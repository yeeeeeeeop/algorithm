import java.io.*;
import java.util.*;

class Solution {

    int[] arr;
    StringBuilder answer = new StringBuilder();

    public void solve() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bubbleSort();

        for (int i = 0; i < n; i++) {
            answer.append(arr[i]).append("\n");
        }

        System.out.print(answer);
    }

    private void bubbleSort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j + 1 < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        sol.solve();
    }
}
