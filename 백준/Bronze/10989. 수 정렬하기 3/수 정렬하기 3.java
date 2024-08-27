import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(arr);

        for (int num : arr) {
            answer.append(num).append("\n");
        }

        System.out.println(answer);
    }
}
