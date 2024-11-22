import java.util.Scanner;

public class Algoritmo346 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String frase;
        int opcao;

        do {

            System.out.println("\nMENU");
            System.out.println("1 - Imprime o comprimento da frase");
            System.out.println("2 - Imprime os dois primeiros e os dois últimos caracteres da frase");
            System.out.println("3 - Imprime a frase espelhada");
            System.out.println("4 - Termina o algoritmo");
            System.out.print("OPÇÃO: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite uma frase: ");
                    frase = scanner.nextLine();
                    System.out.println("Número de caracteres da frase: " + frase.length());
                    break;

                case 2:
                    System.out.print("\nDigite uma frase: ");
                    frase = scanner.nextLine();
                    if (frase.length() >= 2) {
                        System.out.println("Os dois primeiros caracteres: " + frase.substring(0, 2));
                        System.out.println("Os dois últimos caracteres: " + frase.substring(frase.length() - 2));
                    } else {
                        System.out.println("A frase deve ter pelo menos 2 caracteres.");
                    }
                    break;

                case 3:
                    System.out.print("\nDigite uma frase: ");
                    frase = scanner.nextLine();
                    StringBuilder espelhada = new StringBuilder(frase);
                    System.out.println("Frase espelhada: " + espelhada.reverse().toString());
                    break;

                case 4:
                    System.out.println("\nFim do algoritmo.");
                    break;

                default:
                    System.out.println("\nOpção não disponível.");
                    break;
            }
            System.out.println();
        } while (opcao != 4);

        scanner.close();
    }
}

