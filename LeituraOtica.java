import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt();
            if (N == 0) break;

            for (int i = 0; i < N; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();
                int C = sc.nextInt();
                int D = sc.nextInt();
                int E = sc.nextInt();

                int[] valores = {A, B, C, D, E};
                char resposta = determinaResposta(valores);

                System.out.println(resposta);
            }
        }

        sc.close();
    }

    public static char determinaResposta(int[] valores) {
        int marcadas = 0;
        char resposta = '*';

        for (int i = 0; i < valores.length; i++) {
            if (valores[i] <= 127) {
                marcadas++;
                resposta = (char) ('A' + i); 
            }
        }

        if (marcadas == 1) {
            return resposta;
        } else {
            return '*';
        }
    }
}