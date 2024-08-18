import java.util.Scanner;

public class Main {
    public static int solution(String numStr) {
        char[] charArr = numStr.toCharArray();
        int total = 0;

        for (int i = 0; i < charArr.length; i++) {
            total += charArr[i] - '0';
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        System.out.print(solution(str));
    }
}
