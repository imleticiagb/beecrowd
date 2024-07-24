import java.util.Scanner;

public class Main {

    public static int mochila(int[] poderes, int[] pesos, int n, int capacidade) {
        int[][] dp = new int[n + 1][capacidade + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacidade; j++) {
                if (pesos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - pesos[i - 1]] + poderes[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacidade];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();

        for (int t = 0; t < casos; t++) {
            int n = sc.nextInt();
            int[] poderes = new int[n];
            int[] pesos = new int[n];

            for (int i = 0; i < n; i++) {
                poderes[i] = sc.nextInt();
                pesos[i] = sc.nextInt();
            }

            int capacidade = sc.nextInt();
            int resistencia = sc.nextInt();

            int danoMaximo = mochila(poderes, pesos, n, capacidade);

            if (danoMaximo >= resistencia) {
                System.out.println("Missao completada com sucesso");
            } else {
                System.out.println("Falha na missao");
            }
        }

        sc.close();
    }
}
