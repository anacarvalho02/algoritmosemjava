import java.util.Scanner;

public class Algoritmo362 {

    public void executar() {
        Scanner scanner = new Scanner(System.in);
        int[] vet1 = new int[10];
        int[] vet2 = new int[20];
        int[] vetc = new int[10];
        int L = 0;


        for (int i = 0; i < vetc.length; i++) {
            vetc[i] = Integer.MIN_VALUE;
        }


        System.out.println("\nEntrada de dados do vetor 1 (10 elementos):");
        for (int i = 0; i < vet1.length; i++) {
            System.out.print("Entre com o " + (i + 1) + "º elemento: ");
            vet1[i] = scanner.nextInt();
        }


        System.out.println("\nEntrada de dados do vetor 2 (20 elementos):");
        for (int i = 0; i < vet2.length; i++) {
            System.out.print("Entre com o " + (i + 1) + "º elemento: ");
            vet2[i] = scanner.nextInt();
        }


        for (int i = 0; i < vet1.length; i++) {
            int c = 0;


            while (c < vet2.length && vet1[i] != vet2[c]) {
                c++;
            }

            if (c < vet2.length) {
                int d = 0;


                while (d < L && vet1[i] != vetc[d]) {
                    d++;
                }

                if (d == L) {
                    vetc[d] = vet1[i];
                    L++;
                }
            }
        }


        if (L > 0) {
            System.out.println("\n\nElementos comuns:");
            for (int i = 0; i < L; i++) {
                System.out.println(vetc[i]);
            }
        } else {
            System.out.println("\n\nNão existem elementos comuns.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Algoritmo362 algoritmo = new Algoritmo362();
        algoritmo.executar(); // Chamando o método principal
    }
}

