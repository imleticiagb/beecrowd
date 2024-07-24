import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (n == 0 && k == 0) break;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            long[][] dp = new long[n][k + 1];

            for (int i = 0; i < n; i++) {
                dp[i][1] = 1;
            }

            for (int j = 2; j <= k; j++) {
                for (int i = 0; i < n; i++) {
                    for (int m = 0; m < i; m++) {
                        if (arr[m] < arr[i]) {
                            dp[i][j] += dp[m][j - 1];
                        }
                    }
                }
            }

            long result = 0;
            for (int i = 0; i < n; i++) {
                result += dp[i][k];
            }

            System.out.println(result);
        }

        sc.close();
    }
}