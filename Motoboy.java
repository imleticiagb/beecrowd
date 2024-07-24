import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * IMPORTANT:
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int N = scanner.nextInt();
            if (N == 0) {
                break;
            }

            int P = scanner.nextInt();
            int[] tempos = new int[N];
            int[] pizzas = new int[N];

            for (int i = 0; i < N; i++) {
                tempos[i] = scanner.nextInt();
                pizzas[i] = scanner.nextInt();
            }

            int resultado = calcularTempoMaximo(tempos, pizzas, N, P);
            System.out.println(resultado + " min.");
        }

        scanner.close();
    }

    private static int calcularTempoMaximo(int[] tempos, int[] pizzas, int N, int P) {
        int[][] dp = new int[N + 1][P + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= P; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= pizzas[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - pizzas[i - 1]] + tempos[i - 1]);
                }
            }
        }

        return dp[N][P];
    }
}