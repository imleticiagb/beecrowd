import java.util.Scanner;
import java.util.Vector;

class Coordenada {
    int x, y;
    boolean visitada;

    Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
        this.visitada = false;
    }
}

public class Main {

    static int ganhador;

    static void procura(int[][] mat, Coordenada[][] coordenadas, int i, int j) {
        if (i >= 0 && i < 5 && j >= 0 && j < 5 && ganhador == 0) {
            coordenadas[i][j].visitada = true;
            if (i == 4 && j == 4) {
                ganhador = 1;
            } else {
                if (i + 1 < 5 && mat[i + 1][j] == 0 && !coordenadas[i + 1][j].visitada)
                    procura(mat, coordenadas, i + 1, j);
                if (i - 1 >= 0 && mat[i - 1][j] == 0 && !coordenadas[i - 1][j].visitada)
                    procura(mat, coordenadas, i - 1, j);
                if (j + 1 < 5 && mat[i][j + 1] == 0 && !coordenadas[i][j + 1].visitada)
                    procura(mat, coordenadas, i, j + 1);
                if (j - 1 >= 0 && mat[i][j - 1] == 0 && !coordenadas[i][j - 1].visitada)
                    procura(mat, coordenadas, i, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int[][] mat = new int[5][5];
            Coordenada[][] coordenadas = new Coordenada[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    int e = sc.nextInt();
                    mat[i][j] = e;
                    coordenadas[i][j] = new Coordenada(i, j);
                }
            }

            ganhador = 0;
            procura(mat, coordenadas, 0, 0);

            if (ganhador == 1)
                System.out.println("COPS");
            else
                System.out.println("ROBBERS");
        }

        sc.close();
    }
}
