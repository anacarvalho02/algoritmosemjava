
//Algoritmo 356//

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int TOTAL_ALUNOS = 15;

        String[] nomes = new String[TOTAL_ALUNOS];
        double[] pr1 = new double[TOTAL_ALUNOS];
        double[] pr2 = new double[TOTAL_ALUNOS];
        int[] medias = new int[TOTAL_ALUNOS];
        String[] situacoes = new String[TOTAL_ALUNOS];


        for (int i = 0; i < TOTAL_ALUNOS; i++) {

            do {
                System.out.print("\nDigite o nome do aluno " + (i + 1) + " (até 30 caracteres): ");
                nomes[i] = scanner.nextLine();
                if (nomes[i].length() > 30) {
                    System.out.println("O nome deve ter no máximo 30 caracteres. Tente novamente.");
                }
            } while (nomes[i].length() > 30);


            nomes[i] = String.format("%-30s", nomes[i]);


            System.out.print("Digite a nota da PR1: ");
            pr1[i] = scanner.nextDouble();

            System.out.print("Digite a nota da PR2: ");
            pr2[i] = scanner.nextDouble();
            scanner.nextLine();


            medias[i] = (int) Math.round((pr1[i] + pr2[i]) / 2);


            situacoes[i] = (medias[i] >= 5) ? "AP" : "RP";
        }


        System.out.println("\n\n\t\t\tRELACÃO FINAL");
        System.out.printf("%-4s%-30s%-8s%-8s%-8s%-5s\n", "Nº", "Nome", "PR1", "PR2", "Média", "Sit");

        for (int i = 0; i < TOTAL_ALUNOS; i++) {
            System.out.printf("%-4d%-30s%-8.2f%-8.2f%-8d%-5s\n",
                    (i + 1), nomes[i], pr1[i], pr2[i], medias[i], situacoes[i]);
        }

        scanner.close();
    }
}
