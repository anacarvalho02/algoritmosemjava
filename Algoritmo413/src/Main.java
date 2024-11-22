
//Algoritmo 413//

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[5][5];
        int soma = 0;


        System.out.println("Digite os elementos da matriz 5x5:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }


        System.out.println("\nToda a matriz:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }


        for (int i = 1; i < 5; i++) {
            for (int j = 5 - i; j < 5; j++) {
                if (matriz[i][j] % 2 != 0) {
                    soma += matriz[i][j] * matriz[i][j];
                }
            }
        }


        double resultado = Math.sqrt(soma);
        System.out.println("\nRaiz quadrada da soma dos quadrados dos números ímpares abaixo da diagonal secundária: " + resultado);
        scanner.close();
    }
}
