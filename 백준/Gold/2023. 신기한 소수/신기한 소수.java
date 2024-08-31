import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] starts = {2, 3, 5, 7};
    static int[] odds = {1, 3, 5, 7, 9};
    static ArrayList<Integer> answers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();
        n = sc.nextInt();

        for (int start : starts) {
            dfs(start);
        }

        for (int num : answers) {
            answer.append(num).append("\n");
        }

        System.out.print(answer);
    }

    private static void dfs(int curr) {
        if(!isPrime(curr)) {
            return;
        }

        int count = String.valueOf(curr).length();
        if (count == n) {
            answers.add(curr);
            return;
        }

        for (int odd : odds) {
            dfs(curr * 10 + odd);
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
