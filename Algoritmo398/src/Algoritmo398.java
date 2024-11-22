import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Algoritmo398 {
    private static final int MAX_PRODUTOS = 50;
    private int[] codigos = new int[MAX_PRODUTOS];
    private int[] quantidades = new int[MAX_PRODUTOS];
    private double[] precos = new double[MAX_PRODUTOS];
    private int totalProdutos = 0;
    private double totalVendas = 0.0;

    // Método para cadastrar produtos
    public void cadastrarProdutos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto ou -1 para encerrar o cadastro:");
        int codigo = scanner.nextInt();

        while (codigo != -1 && totalProdutos < MAX_PRODUTOS) {
            codigos[totalProdutos] = codigo;

            System.out.print("Digite a quantidade disponível: ");
            quantidades[totalProdutos] = scanner.nextInt();

            System.out.print("Digite o preço do produto: ");
            precos[totalProdutos] = scanner.nextDouble();

            totalProdutos++;
            System.out.println("Digite o código do próximo produto ou -1 para encerrar o cadastro:");
            codigo = scanner.nextInt();
        }

        if (totalProdutos == MAX_PRODUTOS) {
            System.out.println("Cadastro completo. Não é possível adicionar mais produtos.");
        }
    }

    // Método para processar vendas
    public void processarVendas() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite o código do produto para venda ou 0 para encerrar as vendas:");
        int codigo = scanner.nextInt();

        while (codigo != 0) {
            int index = buscarProduto(codigo);

            if (index == -1) {
                System.out.println("Produto Não-Cadastrado.");
            } else {
                System.out.print("Digite a quantidade requerida: ");
                int quantidadeRequerida = scanner.nextInt();

                if (quantidades[index] >= quantidadeRequerida) {
                    quantidades[index] -= quantidadeRequerida;
                    double venda = quantidadeRequerida * precos[index];
                    totalVendas += venda;
                    System.out.printf("Venda realizada! Total: R$ %.2f%n", venda);
                } else {
                    System.out.println("Estoque Insuficiente.");
                }
            }

            System.out.println("\nDigite o código do próximo produto para venda ou 0 para encerrar:");
            codigo = scanner.nextInt();
        }
    }

    // Método para gerar relatório final
    public void gerarRelatorio() {
        System.out.println("\nRelatório Final:");
        System.out.printf("Total vendido no dia: R$ %.2f%n", totalVendas);
        System.out.println("Produtos em estoque (em ordem decrescente de quantidade):");

        ordenarPorQuantidade();

        for (int i = 0; i < totalProdutos; i++) {
            System.out.printf("Código: %d | Quantidade: %d | Preço: R$ %.2f%n",
                    codigos[i], quantidades[i], precos[i]);
        }
    }

    // Método auxiliar para buscar o índice de um produto
    private int buscarProduto(int codigo) {
        for (int i = 0; i < totalProdutos; i++) {
            if (codigos[i] == codigo) {
                return i;
            }
        }
        return -1;
    }

    // Método para ordenar os produtos por quantidade em ordem decrescente
    private void ordenarPorQuantidade() {
        Integer[] indices = new Integer[totalProdutos];
        for (int i = 0; i < totalProdutos; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingInt((Integer i) -> quantidades[i]).reversed());

        int[] codTemp = new int[totalProdutos];
        int[] quantTemp = new int[totalProdutos];
        double[] precoTemp = new double[totalProdutos];

        for (int i = 0; i < totalProdutos; i++) {
            codTemp[i] = codigos[indices[i]];
            quantTemp[i] = quantidades[indices[i]];
            precoTemp[i] = precos[indices[i]];
        }

        System.arraycopy(codTemp, 0, codigos, 0, totalProdutos);
        System.arraycopy(quantTemp, 0, quantidades, 0, totalProdutos);
        System.arraycopy(precoTemp, 0, precos, 0, totalProdutos);
    }

    // Método main para executar o programa
    public static void main(String[] args) {
        Algoritmo398 algoritmo = new Algoritmo398();

        algoritmo.cadastrarProdutos();
        algoritmo.processarVendas();
        algoritmo.gerarRelatorio();
    }
}

