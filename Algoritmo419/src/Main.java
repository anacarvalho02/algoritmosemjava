
//Algoritmo 419//

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] A = new int[5][5];
        int[][] B = new int[5][5];
        int[][] DIF = new int[5][5];


        System.out.println("Digite os elementos da matriz A:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("A[" + (i + 1) + "][" + (j + 1) + "]: ");
                A[i][j] = scanner.nextInt();
            }
        }


        System.out.println("\nDigite os elementos da matriz B:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("B[" + (i + 1) + "][" + (j + 1) + "]: ");
                B[i][j] = scanner.nextInt();

                DIF[i][j] = A[i][j] - B[i][j];
            }
        }


        System.out.println("\nMatriz Diferença:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(DIF[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}
