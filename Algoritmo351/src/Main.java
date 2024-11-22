
//Algoritmo 351//

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[5];


        for (int i = 0; i < nomes.length; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }

        int num;
        do {

            System.out.print("\nDigite o número da pessoa (1 a 5): ");
            num = scanner.nextInt();

            if (num < 1 || num > 5) {
                System.out.println("\nNúmero fora do intervalo. Tente novamente.");
            }
        } while (num < 1 || num > 5);


        System.out.println("\nO nome correspondente é: " + nomes[num - 1]);

        scanner.close();
    }
}