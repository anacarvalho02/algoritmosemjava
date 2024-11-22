import java.util.Scanner;

public class Algoritmo394 {

    private static final int MAX_ALUNOS = 50;
    private String[] nomes = new String[MAX_ALUNOS];
    private double[] nota1 = new double[MAX_ALUNOS];
    private double[] nota2 = new double[MAX_ALUNOS];
    private double[] media = new double[MAX_ALUNOS];
    private boolean nomesCadastrados = false;
    private boolean notas1Cadastradas = false;
    private boolean notas2Cadastradas = false;

    public void executar() {
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            // Exibição do menu
            System.out.println("\n\nESCOLA VIVA");
            System.out.println("1 - Entrar nomes");
            System.out.println("2 - Entrar 1ª nota");
            System.out.println("3 - Entrar 2ª nota");
            System.out.println("4 - Calcular média");
            System.out.println("5 - Listar no display");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarNomes(scanner);
                    break;
                case "2":
                    if (!nomesCadastrados) {
                        System.out.println("\nNomes ainda não cadastrados.");
                    } else {
                        cadastrarNotas(scanner, 1);
                        notas1Cadastradas = true;
                    }
                    break;
                case "3":
                    if (!nomesCadastrados) {
                        System.out.println("\nNomes ainda não cadastrados.");
                    } else {
                        cadastrarNotas(scanner, 2);
                        notas2Cadastradas = true;
                    }
                    break;
                case "4":
                    if (!nomesCadastrados || !notas1Cadastradas || !notas2Cadastradas) {
                        System.out.println("\nNem todos os dados estão cadastrados.");
                    } else {
                        calcularMedias();
                        System.out.println("\nMédias calculadas com sucesso.");
                    }
                    break;
                case "5":
                    if (!nomesCadastrados || !notas1Cadastradas || !notas2Cadastradas) {
                        System.out.println("\nNem todos os dados estão cadastrados.");
                    } else {
                        listarAlunos();
                    }
                    break;
                case "6":
                    System.out.println("\nSaindo...");
                    break;
                default:
                    System.out.println("\nOpção não disponível.");
            }
        } while (!opcao.equals("6"));

        scanner.close();
    }


    private void cadastrarNomes(Scanner scanner) {
        System.out.println("\nDigite os nomes dos 50 alunos (em letras maiúsculas):");
        for (int i = 0; i < MAX_ALUNOS; i++) {
            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine().toUpperCase();
        }
        nomesCadastrados = true;
        System.out.println("\nNomes cadastrados com sucesso.");
    }


    private void cadastrarNotas(Scanner scanner, int notaIndex) {
        System.out.println("\nDigite as notas dos 50 alunos:");
        for (int i = 0; i < MAX_ALUNOS; i++) {
            System.out.print("Digite a " + notaIndex + "ª nota de " + nomes[i] + ": ");
            if (notaIndex == 1) {
                nota1[i] = scanner.nextDouble();
            } else {
                nota2[i] = scanner.nextDouble();
            }
        }
        scanner.nextLine();
        System.out.println("\nNotas cadastradas com sucesso.");
    }


    private void calcularMedias() {
        for (int i = 0; i < MAX_ALUNOS; i++) {
            media[i] = (3 * nota1[i] + 7 * nota2[i]) / 10.0;
        }
    }


    private void listarAlunos() {
        System.out.println("\nNOME\t\t\tNOTA1\tNOTA2\tMÉDIA");
        for (int i = 0; i < MAX_ALUNOS; i++) {
            System.out.printf("%-30s\t%.2f\t%.2f\t%.2f\n", nomes[i], nota1[i], nota2[i], media[i]);
        }
    }

    public static void main(String[] args) {
        Algoritmo394 algoritmo = new Algoritmo394();
        algoritmo.executar();
    }
}
