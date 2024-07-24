import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String linha = scanner.nextLine();
            char digito1 = linha.charAt(0);
            char digito2 = linha.charAt(2);

            if (digito1 == digito2) {
                System.out.println(Character.getNumericValue(digito1) * Character.getNumericValue(digito2));
            } else if ('A' <= linha.charAt(1) && linha.charAt(1) <= 'Z') {
                System.out.println(Character.getNumericValue(digito2) - Character.getNumericValue(digito1));
            } else {
                System.out.println(Character.getNumericValue(digito1) + Character.getNumericValue(digito2));
            }
        }

        scanner.close();
    }
}
