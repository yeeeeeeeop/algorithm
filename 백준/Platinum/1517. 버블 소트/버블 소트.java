import java.io.*;
import java.util.*;

class Solution {

    int[] arr, tmp;
    int n;
    long swapCount = 0;

    public void solve() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        arr = new int[n + 1];
        tmp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(1, n);

        System.out.print(swapCount);
    }

    private void mergeSort(int left, int right) {
        if (right - left < 1) return;

        int mid = left + (right - left) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        System.arraycopy(arr, left, tmp, left, right + 1 - left);

        int currIndex = left;
        int index1 = left;
        int index2 = mid + 1;

        while (index1 <= mid && index2 <= right) {
            if (tmp[index1] > tmp[index2]) {
                swapCount += (index2 - currIndex);
                arr[currIndex++] = tmp[index2++];
            } else {
                arr[currIndex++] = tmp[index1++];
            }
        }

        while (index1 <= mid) {
            arr[currIndex++] = tmp[index1++];
        }

        while (index2 <= right) {
            arr[currIndex++] = tmp[index2++];
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        sol.solve();
    }
}
