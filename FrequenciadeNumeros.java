import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeDeNumeros = scanner.nextInt();

        Map<Integer, Integer> frequencia = new HashMap<>();
        for (int i = 0; i < quantidadeDeNumeros; i++) {
            int numero = scanner.nextInt();
            frequencia.put(numero, frequencia.getOrDefault(numero, 0) + 1);
        }

        Map<Integer, Integer> frequenciaOrdenada = new TreeMap<>(frequencia);
        for (Map.Entry<Integer, Integer> entrada : frequenciaOrdenada.entrySet()) {
            System.out.println(entrada.getKey() + " aparece " + entrada.getValue() + " vez(es)");
        }
    }
}