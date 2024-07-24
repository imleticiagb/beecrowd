import java.util.Scanner;

public class Main {

    public static boolean pagaMoedas(int V, int N, int[] moedas) {
        boolean[] dp = new boolean[V + 1];
        dp[0] = true;

        for (int moeda : moedas) {
            for (int j = V; j >= moeda; j--) {
                dp[j] = dp[j] || dp[j - moeda];
            }
        }
        
        return dp[V];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int V = sc.nextInt();
            int N = sc.nextInt();

            if (V == 0 && N == 0) {
                break;
            }

            int[] moedas = new int[N];
            for (int i = 0; i < N; i++) {
                moedas[i] = sc.nextInt();
            }

            if (pagaMoedas(V, N, moedas)) {
                System.out.println("sim");
            } else {
                System.out.println("nao");
            }
        }
        
        sc.close();
    }
}