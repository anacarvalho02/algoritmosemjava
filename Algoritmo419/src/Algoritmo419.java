import java.util.Scanner;

public class Algoritmo419 {

    private int[][] matrizA;
    private int[][] matrizB;
    private int[][] matrizDiferenca;
    private final int ORDEM = 5;

    public Algoritmo419() {
        matrizA = new int[ORDEM][ORDEM];
        matrizB = new int[ORDEM][ORDEM];
        matrizDiferenca = new int[ORDEM][ORDEM];
    }

    // Método para ler a matriz A
    public void lerMatrizA() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os elementos da matriz A:");
        for (int i = 0; i < ORDEM; i++) {
            for (int j = 0; j < ORDEM; j++) {
                System.out.print("A[" + (i + 1) + "][" + (j + 1) + "]: ");
                matrizA[i][j] = scanner.nextInt();
            }
        }
    }

    // Método para ler a matriz B
    public void lerMatrizB() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite os elementos da matriz B:");
        for (int i = 0; i < ORDEM; i++) {
            for (int j = 0; j < ORDEM; j++) {
                System.out.print("B[" + (i + 1) + "][" + (j + 1) + "]: ");
                matrizB[i][j] = scanner.nextInt();
            }
        }
    }

    // Método para calcular a matriz diferença
    public void calcularMatrizDiferenca() {
        for (int i = 0; i < ORDEM; i++) {
            for (int j = 0; j < ORDEM; j++) {
                matrizDiferenca[i][j] = matrizA[i][j] - matrizB[i][j];
            }
        }
    }

    // Método para exibir a matriz diferença
    public void exibirMatrizDiferenca() {
        System.out.println("\nMatriz Diferença:");
        for (int i = 0; i < ORDEM; i++) {
            for (int j = 0; j < ORDEM; j++) {
                System.out.print(matrizDiferenca[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Método principal para executar a lógica
    public void executar() {
        lerMatrizA();
        lerMatrizB();
        calcularMatrizDiferenca();
        exibirMatrizDiferenca();
    }

    // Método main para rodar a classe
    public static void main(String[] args) {
        Algoritmo419 algoritmo = new Algoritmo419();
        algoritmo.executar();
    }
}
