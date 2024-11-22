import java.util.Scanner;

public class Algoritmo351 {
    private String[] nomes;


    public Algoritmo351() {
        nomes = new String[5];
    }

    // Método para coletar os nomes
    public void coletarNomes() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < nomes.length; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }
    }

    // Método para buscar um nome pelo número
    public void buscarNomePorNumero() {
        Scanner scanner = new Scanner(System.in);
        int num;

        do {
            System.out.print("\nDigite o número da pessoa (1 a 5): ");
            num = scanner.nextInt();

            if (num < 1 || num > 5) {
                System.out.println("\nNúmero fora do intervalo. Tente novamente.");
            }
        } while (num < 1 || num > 5);

        System.out.println("\nO nome correspondente é: " + nomes[num - 1]);
    }

    public static void main(String[] args) {

        Algoritmo351 programa = new Algoritmo351();


        programa.coletarNomes();
        programa.buscarNomePorNumero();
    }
}
