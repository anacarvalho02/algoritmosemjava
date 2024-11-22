
//Algoritmo 400//

import java.util.Scanner;

public class Main {
    private static final int MAX_QUARTOS = 50;

    private int[] leitos = new int[MAX_QUARTOS];
    private double[] precos = new double[MAX_QUARTOS];
    private String[] situacoes = new String[MAX_QUARTOS];
    private String[] datasEntrada = new String[MAX_QUARTOS];
    private String[] datasSaida = new String[MAX_QUARTOS];
    private String[] nomes = new String[MAX_QUARTOS];
    private String[] telefones = new String[MAX_QUARTOS];
    private int[] numDiarias = new int[MAX_QUARTOS];
    private double[] despesas = new double[MAX_QUARTOS];
    private boolean cadastroFeito = false;

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n\nHotel Fazenda Sucesso");
            System.out.println("1. Cadastra quartos");
            System.out.println("2. Lista todos os quartos");
            System.out.println("3. Lista quartos desocupados");
            System.out.println("4. Aluguel/reserva quarto");
            System.out.println("5. Entra despesas extras");
            System.out.println("6. Calcula despesa do quarto");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> cadastrarQuartos();
                case 2 -> listarTodosQuartos();
                case 3 -> listarQuartosDesocupados();
                case 4 -> aluguelOuReserva();
                case 5 -> entrarDespesasExtras();
                case 6 -> calcularDespesa();
                case 7 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);
    }

    private void cadastrarQuartos() {
        if (cadastroFeito) {
            System.out.println("Atenção: Dados já cadastrados.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < MAX_QUARTOS; i++) {
            System.out.println("Cadastro do quarto " + (i + 1));
            System.out.print("Quantidade de leitos: ");
            leitos[i] = scanner.nextInt();

            System.out.print("Preço do quarto: ");
            precos[i] = scanner.nextDouble();

            situacoes[i] = "L"; // Livre
            datasEntrada[i] = "XXXX";
            datasSaida[i] = "XXXX";
            nomes[i] = "";
            telefones[i] = "";
            numDiarias[i] = 0;
            despesas[i] = 0.0;
        }

        cadastroFeito = true;
        System.out.println("Cadastro de quartos concluído!");
    }

    private void listarTodosQuartos() {
        if (!cadastroFeito) {
            System.out.println("Escolha a opção 1 para cadastrar os quartos primeiro.");
            return;
        }

        for (int i = 0; i < MAX_QUARTOS; i++) {
            System.out.println("Número do quarto: " + (i + 1));
            System.out.println("Situação: " + situacoes[i]);
            System.out.println("Leitos: " + leitos[i]);
            System.out.println("Preço: R$ " + precos[i]);
            System.out.println("Despesas: R$ " + despesas[i]);
            System.out.println("Data de entrada: " + datasEntrada[i]);
            System.out.println("Data de saída: " + datasSaida[i]);
            System.out.println("Número de diárias: " + numDiarias[i]);
            if (!nomes[i].isEmpty()) {
                System.out.println("Nome do hóspede: " + nomes[i]);
                System.out.println("Telefone: " + telefones[i]);
            }
            System.out.println();
        }
    }

    private void listarQuartosDesocupados() {
        if (!cadastroFeito) {
            System.out.println("Escolha a opção 1 para cadastrar os quartos primeiro.");
            return;
        }

        System.out.println("Quartos desocupados:");
        for (int i = 0; i < MAX_QUARTOS; i++) {
            if (situacoes[i].equals("L")) {
                System.out.println("Número do quarto: " + (i + 1));
                System.out.println("Leitos: " + leitos[i]);
                System.out.println("Preço: R$ " + precos[i]);
                System.out.println();
            }
        }
    }

    private void aluguelOuReserva() {
        if (!cadastroFeito) {
            System.out.println("Escolha a opção 1 para cadastrar os quartos primeiro.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite A (aluguel) ou R (reserva):");
        String tipo = scanner.next().toUpperCase();

        if (!tipo.equals("A") && !tipo.equals("R")) {
            System.out.println("Opção inválida.");
            return;
        }

        listarQuartosDesocupados();
        System.out.print("Escolha o número do quarto: ");
        int numeroQuarto = scanner.nextInt() - 1;

        if (numeroQuarto < 0 || numeroQuarto >= MAX_QUARTOS || !situacoes[numeroQuarto].equals("L")) {
            System.out.println("Quarto inválido ou já ocupado.");
            return;
        }

        situacoes[numeroQuarto] = tipo.equals("A") ? "A" : "R";
        System.out.print("Nome do hóspede: ");
        scanner.nextLine(); // Consumir quebra de linha
        nomes[numeroQuarto] = scanner.nextLine();

        System.out.print("Telefone: ");
        telefones[numeroQuarto] = scanner.nextLine();

        System.out.print("Data de entrada: ");
        datasEntrada[numeroQuarto] = scanner.nextLine();

        System.out.print("Data de saída: ");
        datasSaida[numeroQuarto] = scanner.nextLine();

        System.out.print("Número de diárias: ");
        numDiarias[numeroQuarto] = scanner.nextInt();

        System.out.println("Quarto reservado/alugado com sucesso!");
    }

    private void entrarDespesasExtras() {
        if (!cadastroFeito) {
            System.out.println("Escolha a opção 1 para cadastrar os quartos primeiro.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt() - 1;

        if (numeroQuarto < 0 || numeroQuarto >= MAX_QUARTOS || situacoes[numeroQuarto].equals("L")) {
            System.out.println("Quarto inválido ou desocupado.");
            return;
        }

        System.out.print("Digite o valor da despesa extra: ");
        double valor = scanner.nextDouble();
        despesas[numeroQuarto] += valor;

        System.out.println("Despesa adicionada com sucesso!");
    }

    private void calcularDespesa() {
        if (!cadastroFeito) {
            System.out.println("Escolha a opção 1 para cadastrar os quartos primeiro.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt() - 1;

        if (numeroQuarto < 0 || numeroQuarto >= MAX_QUARTOS) {
            System.out.println("Número do quarto inválido.");
            return;
        }

        double total = numDiarias[numeroQuarto] * precos[numeroQuarto] + despesas[numeroQuarto];
        System.out.printf("Total a ser pago pelo quarto %d: R$ %.2f%n", numeroQuarto + 1, total);

        // Finalizando estadia
        situacoes[numeroQuarto] = "L";
        despesas[numeroQuarto] = 0.0;
        datasEntrada[numeroQuarto] = "XXXX";
        datasSaida[numeroQuarto] = "XXXX";
        nomes[numeroQuarto] = "";
        telefones[numeroQuarto] = "";
        numDiarias[numeroQuarto] = 0;
    }

    public static void main(String[] args) {
        Main hotel = new Main();
        hotel.menu();
    }
}
