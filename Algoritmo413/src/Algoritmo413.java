import java.util.Scanner;

public class Algoritmo413 {
    private int[][] matriz = new int[5][5];
    private int soma = 0;


    public void entradaDados() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os elementos da matriz 5x5:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }


    public void exibirMatriz() {
        System.out.println("\nToda a matriz:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public void calcularSomaQuadrados() {
        for (int i = 1; i < 5; i++) { // Começa da linha 1
            for (int j = 5 - i; j < 5; j++) { // Elementos abaixo da diagonal secundária
                if (matriz[i][j] % 2 != 0) { // Verifica se o número é ímpar
                    soma += matriz[i][j] * matriz[i][j];
                }
            }
        }
    }


    public void exibirRaizQuadrada() {
        double resultado = Math.sqrt(soma);
        System.out.println("\nRaiz quadrada da soma dos quadrados dos números ímpares abaixo da diagonal secundária: " + resultado);
    }


    public static void main(String[] args) {
        Algoritmo413 algoritmo = new Algoritmo413();
        algoritmo.entradaDados();
        algoritmo.exibirMatriz();
        algoritmo.calcularSomaQuadrados();
        algoritmo.exibirRaizQuadrada();
    }
}

