
//ALGORITMO 348//

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] nomes = new String[5];
        double[] nota1 = new double[5];
        double[] nota2 = new double[5];
        double[] medias = new double[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite o nome do " + (i + 1) + "º aluno:");
            nomes[i] = scanner.nextLine();

            System.out.println("Digite a 1ª nota do aluno:");
            nota1[i] = scanner.nextDouble();

            System.out.println("Digite a 2ª nota do aluno:");
            nota2[i] = scanner.nextDouble();


            scanner.nextLine();


            medias[i] = (nota1[i] + nota2[i]) / 2;
        }


        System.out.println("\n\t\t\tRELACAO FINAL");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + " - " + nomes[i]);
            System.out.println("Notas: " + nota1[i] + ", " + nota2[i]);
            System.out.println("Média: " + medias[i]);
        }

        scanner.close();
    }
}
