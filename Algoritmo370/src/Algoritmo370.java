import java.util.Scanner;

public class Algoritmo370 {

    public void executar() {
        Scanner scanner = new Scanner(System.in);
        int nv;
        String[] nomes;
        int[] lugares;


        System.out.print("\nEntre com o número de voos: ");
        nv = scanner.nextInt();
        scanner.nextLine();

        nomes = new String[nv];
        lugares = new int[nv];


        for (int i = 0; i < nv; i++) {
            System.out.print("\nEntre com a identificação do voo " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();

            System.out.print("Entre com a quantidade de lugares disponíveis no voo " + nomes[i] + ": ");
            lugares[i] = scanner.nextInt();
            scanner.nextLine();
        }


        String nvd;
        System.out.print("\nEntre com o número do voo desejado ou @ para terminar: ");
        nvd = scanner.nextLine();

        while (!nvd.equals("@")) {
            int i = 0;


            while (i < nv && !nomes[i].equals(nvd)) {
                i++;
            }

            if (i < nv) {
                if (lugares[i] > 0) {
                    lugares[i]--;
                    System.out.print("\nQual o número da identidade do cliente? ");
                    String id = scanner.nextLine();
                    System.out.println("Identidade: " + id + " Voo: " + nvd + "\n");
                } else {
                    System.out.println("\nNão existem mais lugares neste voo.\n");
                }
            } else {
                System.out.println("\nNão existe este voo.\n");
            }


            System.out.print("\nEntre com o número do voo desejado ou @ para terminar: ");
            nvd = scanner.nextLine();
        }

        System.out.println("\nReservas encerradas.");
        scanner.close();
    }

    public static void main(String[] args) {
        Algoritmo370 algoritmo = new Algoritmo370();
        algoritmo.executar();
    }
}
