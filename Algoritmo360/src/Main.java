
//Algoritmo 360//

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ultdia = new int[12];
        String[] signos = new String[12];
        int data, dia, mes;


        System.out.println("Digite os signos e os últimos dias de cada mês:");
        for (int i = 0; i < 12; i++) {
            System.out.print("\nDigite o signo do mês " + (i + 1) + ": ");
            signos[i] = scanner.next();
            System.out.print("Digite o último dia do signo " + signos[i] + ": ");
            ultdia[i] = scanner.nextInt();
        }


        System.out.println("\nDigite a data no formato ddmm ou 9999 para terminar:");
        data = scanner.nextInt();

        while (data != 9999) {
            dia = data / 100;
            mes = data % 100;
            mes--;

            if (dia > ultdia[mes]) {
                mes = (mes + 1) % 12;
            }

            System.out.println("\nSigno: " + signos[mes]);
            System.out.println("\nDigite a próxima data no formato ddmm ou 9999 para terminar:");
            data = scanner.nextInt();
        }

        System.out.println("\nPrograma encerrado.");
        scanner.close();
    }
}
