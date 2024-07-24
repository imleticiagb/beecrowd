import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int X1 = scanner.nextInt();
            int Y1 = scanner.nextInt();
            int X2 = scanner.nextInt();
            int Y2 = scanner.nextInt();

            if (X1 == 0 && Y1 == 0 && X2 == 0 && Y2 == 0) {
                break;
            }

            int queen;
            if (X1 == X2 && Y1 == Y2) {
                queen = 0; 
            } else if (X1 == X2 || Y1 == Y2 || Math.abs(X1 - X2) == Math.abs(Y1 - Y2)) {
                queen = 1; 
            } else {
                queen = 2;
            }

            System.out.println(queen);
        }

        scanner.close();
    }
}
