import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        for (int i = 0; i < N; i++) {
            int T = scanner.nextInt();
            int[] alturas = new int[T];
            for (int j = 0; j < T; j++) {
                alturas[j] = scanner.nextInt();
            }
            String pulos = scanner.next();
            
            int atingido = 0;
            for (int j = 0; j < T; j++) {
                int alturaTiro = alturas[j];
                char acao = pulos.charAt(j);
                
                if ((alturaTiro <= 2 && acao == 'S') || (alturaTiro > 2 && acao == 'J')) {
                    atingido++;
                }
            }
            
            System.out.println(atingido);
        }
        
        scanner.close();
    }
}
